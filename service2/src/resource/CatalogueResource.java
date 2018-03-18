package resource;

import dao.CatalogueDAO;
import domain.Product;
import org.jooby.Jooby;
import org.jooby.MediaType;
import org.jooby.Status;

public class CatalogueResource extends Jooby {

	public CatalogueResource(CatalogueDAO dao) {

		path("/api/catalogue", () -> {

			/**
			 * Gets all of the products in the catalogue (ordered by ID).
			 *
			 * @return <code>200</code> with the products in the catalogue.
			 */
			get(() -> {
				return dao.getCatalogue();
			});

			/**
			 * Adds a product to the catalogue.
			 *
			 * @param body The product to add to the catalogue.
			 * @return <code>201</code> with the product's details (including the
			 * URI) if successful or <code>422</code> if a product already exists
			 * with the same ID.
			 */
			post((req, rsp) -> {
				Product product = req.body(Product.class);

				// construct the URI for this product
				String uri = "http://" + req.hostname() + ":" + req.port() + "" + req.path() + "/product/" + product.getId();

				// tell the product about its URI
				product.setUri(uri);

				// store the product
				dao.addItem(product);

				// return a response containing the product
				rsp.status(Status.CREATED).send(product);

			});

		}).produces(MediaType.json).consumes(MediaType.json);

	}

}
