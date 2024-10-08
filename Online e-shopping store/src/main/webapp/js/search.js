document.addEventListener('DOMContentLoaded', function () {
    // Get the search input field and button
    const searchInput = document.getElementById('searchinput');
    const searchButton = document.querySelector('.btn-primary[type="button"]');

    // Add event listener to the search button
    searchButton.addEventListener('click', function () {
        // Get the search term entered by the user
        const searchTerm = searchInput.value.toLowerCase().trim();

        // Get all the product cards
        const products = document.querySelectorAll('.product-card');

        // Loop through each product card and filter
        products.forEach(function (product) {
            const productName = product.querySelector('.card-title').innerText.toLowerCase();
            const productCategory = product.querySelector('.category').innerText.toLowerCase();

            // Check if the search term is in the product name or category
            if (productName.includes(searchTerm) || productCategory.includes(searchTerm)) {
                // If match found, show the product card
                product.style.display = 'block';
            } else {
                // If no match, hide the product card
                product.style.display = 'none';
            }
        });
    });
});