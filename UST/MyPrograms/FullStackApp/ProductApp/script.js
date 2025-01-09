// DOM elements for sections
const homeSection = document.getElementById('homeSection');
const productsSection = document.getElementById('productsSection');
const aboutSection = document.getElementById('aboutSection');

// DOM elements for Add Task and View Tasks subsections
const addProductFormSection = document.getElementById('addProductFormSection');
const viewProductsSection = document.getElementById('viewProductsSection');

// Task form and task list container
const productForm = document.getElementById('productForm');
const productCards = document.getElementById('productCards');

let editMode = false; // Edit mode flag
let productToEditId = null; // Holds the task ID to edit

// Function to show the appropriate main section (home, tasks, about)
function showSection(section) {
    homeSection.style.display = 'none';
    productsSection.style.display = 'none';
    aboutSection.style.display = 'none';
    
    addProductFormSection.style.display = 'none';
    viewProductsSection.style.display = 'none';

    if (section === 'home') {
        homeSection.style.display = 'block';
    } else if (section === 'products') {
        productsSection.style.display = 'block';
    } else if (section === 'about') {
        aboutSection.style.display = 'block';
    }
}

// Function to show the Add Task form
function showAddProductForm() {
    addProductFormSection.style.display = 'block';
    viewProductsSection.style.display = 'none';
    
    productForm.reset();
    editMode = false;
    productToEditId = null;
}

// Function to show the View Tasks section and load tasks
async function showViewProducts() {
    addProductFormSection.style.display = 'none';
    viewProductsSection.style.display = 'block';
    loadAndDisplayProducts();
}

// Load tasks and display them in cards
async function loadAndDisplayProducts() {
    const products = await loadProducts();
    productCards.innerHTML = '';
    products.forEach(product => displayProduct(product));
}

// Handle adding new tasks or updating existing tasks
productForm.onsubmit = async function (e) {
    e.preventDefault();
    
    const newProduct = {
        id: document.getElementById('productId').value,  
        name: document.getElementById('productName').value,
        category: document.getElementById('category').value,
        quantity: document.getElementById('productQuantity').value,
        price: document.getElementById('productPrice').value  // Fixed status variable
    };

    if (editMode) {
        await updateProduct(productToEditId, newProduct);
        editMode = false;
        productToEditId = null;
    } else {
        await createProduct(newProduct);
    }

    productForm.reset();
    showViewProducts();
};

// Display a task card
function displayProduct(product) {
    const productCard = document.createElement('div');
    productCard.classList.add('col-md-4', 'mb-4');
    productCard.innerHTML = `
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Name: ${product.name}</h5>
                <p class="card-text">Category: ${product.category}</p>
                <p class="card-text">Quantity: ${product.quantity}</p>
                <p class="card-text">${product.price}</p>
    
                <button class="btn btn-primary btn-sm" onclick="editProduct(${product.id})">Edit</button>
                <button class="btn btn-danger btn-sm" onclick="removeProduct(${product.id})">Delete</button>
            </div>
        </div>
    `;
    productCards.appendChild(productCard);
}

// Edit an existing task
async function editProduct(id) {
    const product = await getProductById(id);
    showAddProductForm();
    document.getElementById('productId').value = product.id;
    document.getElementById('productName').value = product.name;
    document.getElementById('category').value = product.category;
    document.getElementById('productQuantity').value = product.quantity;
    document.getElementById('productPrice').value = product.price;
    
    editMode = true;
    productToEditId = product.id;
}

// Remove a task
async function removeProduct(id) {
    await deleteProduct(id);
    showViewProducts();
}

// Load all tasks when the page loads
window.onload = function () {
    showSection('home');
};
