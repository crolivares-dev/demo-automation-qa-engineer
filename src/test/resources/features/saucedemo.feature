@sauce
Feature: Compra y gestión de carrito en Sauce Demo

  Scenario: Login exitoso y adición de producto al carrito
    Given el usuario navega a la URL de Sauce Demo
    When ingresa el usuario "standard_user" y la contraseña "secret_sauce"
    Then se muestra el catálogo de productos de Sauce Demo
    When agrega el primer producto al carrito
    Then el producto se añade correctamente al carrito