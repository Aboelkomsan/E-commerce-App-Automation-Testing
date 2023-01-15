@smoke
Feature: user can add a product to his wishlist

  Scenario: user can add a product to his Wishlist successfully
    When user clicks wish button for "HTC One M8 Android L 5.0 Lollipop"
    Then success message "The product has been added to your wishlist" with green background color is displayed

  Scenario: user can add a product to his wishlist successfully then make sure that this product
  is added successfully to his whishlist by waitting  until success message disappear then click on wishlist button
  on top of the page
    When user clicks wish button for "HTC One M8 Android L 5.0 Lollipop"
    And  wait until success message disappear
    Then click on Wishlist Tab on the top of the page