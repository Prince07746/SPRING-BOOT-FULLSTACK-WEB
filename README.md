### Spring Boot Fullstack Web Application

---

### Overview
This project is a Spring Boot full-stack web application designed for managing products. It follows the Model-View-Controller (MVC) design pattern and integrates a front-end interface for user interactions with back-end services and a database.

---

### Purpose
The application aims to:
1. Manage products by supporting CRUD (Create, Read, Update, Delete) operations.
2. Provide a user-friendly web interface for product interactions.
3. Leverage the Thymeleaf template engine for dynamic front-end rendering.
4. Use Spring Boot for rapid application development with integrated JPA for database interactions.

---

![image](https://github.com/user-attachments/assets/0fde617c-2cf2-4fc2-81ad-20718a5ee62f)

![image](https://github.com/user-attachments/assets/f3344df0-5e49-49f2-811c-2137f089e0ec)


### Architecture

1. **Model Layer**
   - **Product.java**
     - Represents the `Product` entity with attributes:
       - `id` (Long): Unique identifier.
       - `name` (String): Product name.
       - `price` (double): Product price.
       - `description` (String): Product description.
     - Annotated with `@Entity` for JPA persistence.

2. **Repository Layer**
   - **ProductRepository.java**
     - Extends `JpaRepository<Product, Long>`, enabling CRUD operations on the `Product` model with minimal boilerplate.

3. **Service Layer**
   - **ProductService.java**
     - Defines the core business logic for:
       - Creating products.
       - Fetching all products or by ID.
       - Updating and deleting products.
   - **ProductServiceImpl.java**
     - Implements `ProductService`.
     - Manages interactions with `ProductRepository`.

4. **Controller Layer**
   - **ProductController.java**
     - Maps HTTP requests to appropriate service methods.
     - Handles:
       - Displaying all products (`/products`).
       - Creating new products (`/products/new`, `POST /products`).
       - Editing existing products (`/products/edit/{id}`, `POST /products/{id}`).
       - Deleting products (`POST /products/delete/{id}`).

5. **View Layer**
   - Thymeleaf templates for the front-end:
     - **createProduct.html** - Form for adding new products.
     - **editProductForm.html** - Form for editing existing products.
     - **product.html** - Displays a list of products with options to edit or delete.

---

### Configuration

- **application.properties**
  - Configures the in-memory H2 database for testing and development.
  - Enables the H2 console for debugging and quick schema inspections.
  - Activates JPA features like schema auto-generation (`ddl-auto=update`) and SQL logging.

---

### Key Features

1. **Product Management**
   - Add, view, edit, and delete products via a web interface.

2. **Database Integration**
   - Uses JPA to interact with an H2 in-memory database.

3. **Thymeleaf Templates**
   - Provides dynamic and responsive front-end rendering.

4. **Spring Boot Simplicity**
   - Leverages Spring Boot's auto-configuration for rapid application development.

---

### Code Example

**Main Application (`App.java`):**
```java
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println("Server made by prince up!!");
    }
}
```

**Controller Example (`ProductController.java`):**
```java
@GetMapping("/products")
public String getProduct(Model model) {
    model.addAttribute("products", productService.getAllProducts());
    return "product";
}

@PostMapping("/products")
public String saveProduct(@ModelAttribute("product") Product product) {
    productService.saveProduct(product);
    return "redirect:/products";
}
```

**Thymeleaf Example (`product.html`):**
```html
<tr th:each="product : ${products}">
    <td th:text="${product.id}"></td>
    <td th:text="${product.name}"></td>
    <td th:text="${product.price} + '€' "></td>
    <td th:text="${product.description}"></td>
    <td>
        <a th:href="@{/products/edit/{id}(id=${product.id})}">Edit</a> |
        <form th:action="@{/products/delete/{id}(id=${product.id})}" method="post" style="display:inline;">
            <button type="submit" onclick="return confirm('Are you sure?');">Delete</button>
        </form>
    </td>
</tr>
```

---

### Running the Application

1. Clone the repository.
2. Configure the database in `application.properties`.
3. Run `App.java` as a Spring Boot application.
4. Access the web interface at `http://localhost:8080/products`.

---

### Conclusion
This project provides a foundational full-stack application for product management. It demonstrates key concepts of Spring Boot, JPA, and Thymeleaf, making it an excellent template for similar CRUD-based applications.

---
