package resource;

import dao.CatalogueDAO;
import domain.Product;
import org.jooby.Err;
import org.jooby.Jooby;
import org.jooby.MediaType;
import org.jooby.Status;

public class ProductResource extends Jooby {

	public ProductResource(CatalogueDAO dao) {

		path("/api/catalogue/product", () -> {

			/**
			 * Get a product's details.
			 *
			 * @param id The product's ID.
			 * @return <code>200</code> with the product matching the given name in
			 * the body, or a <code>404</code> if the ID does not match an existing
			 * product.
			 */
			get("/:id", (req) -> {

				String id = req.param("id").value();

				if (dao.exists(id)) {
					return dao.getById(id);
				} else {
					throw new Err(Status.NOT_FOUND, "No item matches that name");
				}

			});

			/**
			 * Delete an item from the list.
			 *
			 * @param id The product's ID.
			 * @return <code>204</code> for a successful operation, or a
			 * <code>404</code> if the ID does not match an existing product.
			 */
			delete("/:id", (req, rsp) -> {
				String id = req.param("id").value();

				if (dao.exists(id)) {
					dao.delete(id);
					rsp.status(Status.NO_CONTENT);
				} else {
					rsp.status(Status.NOT_FOUND);
				}
			});

			/**
			 * Update an existing item.
			 *
			 * @param id The product's ID.
			 * @param body The new details for the item.
			 * @return <code>204</code> for a successful operation.
			 * <code>404</code> if the ID does not match an existing product.
			 * <code>409</code> if user has attempted to change the ID (which is
			 * not allowed).
			 */
			put("/:id", (req, rsp) -> {
				String id = req.param("id").value();
				Product item = req.body().to(Product.class);

				if (!dao.exists(id)) {
					rsp.status(Status.NOT_FOUND);

					// make sure user is not changing the ID, which could cause data
					// corruption (PKs should always be immutable).
				} else if (!id.equals(item.getId())) {
					rsp.status(Status.CONFLICT);
				} else {
					rsp.status(Status.NO_CONTENT);
					dao.updateItem(id, item);
				}
			});

		}).produces(MediaType.json).consumes(MediaType.json);

	}

}
