# Created by oscar at 4/11/2020
Feature: prestar
  # Enter feature description here

  Scenario: prestar socio no tiene nada prestado
    Given un socio
    And un producto
    When el socio quiere coger prestado el producto
    Then el socio consigue el producto


  Scenario: prestar socio con algo prestado
    Given un socio con algo prestado ya
    And un producto
    When el socio quiere coger prestado el producto
    Then el socio no consigue el producto
