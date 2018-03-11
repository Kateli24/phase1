package service;

import dao.CatalogueDAO;
import domain.Product;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import org.jooby.Jooby;
import org.jooby.apitool.ApiTool;
import org.jooby.json.Gzon;
import resource.CatalogueResource;
import resource.ProductResource;

public class Service extends Jooby {

	public Service() {

		CatalogueDAO dao = new CatalogueDAO();

		use(new Gzon());
		use(new CatalogueResource(dao));
		use(new ProductResource(dao));

		use(new ApiTool()
				.modify(r -> r.pattern().equals("/api/catalogue"), route -> {

					// Fix response type since Swagger couldn't guess
					route.response().type(new Product[0].getClass());

				})
				.swagger());

	}

	public static void main(String[] args) throws IOException {

		Service server = new Service();

		CompletableFuture.runAsync(() -> {
			server.start();
		});

		server.onStarted(() -> {
			System.out.println("\nPress Enter to stop service.");
		});

		System.in.read();
		server.stop();
	}

}
