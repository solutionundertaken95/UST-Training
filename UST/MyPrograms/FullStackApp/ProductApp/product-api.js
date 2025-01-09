const apiBaseUrl = 'http://localhost:8000/api/v1/products'; 

// Load tasks from the server and return them
async function loadProducts() {
    const response = await fetch(apiBaseUrl);
    return response.json();
}

// Create a new task
async function createProduct(product) {
    await fetch(apiBaseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(product)
    });
}

// Update an existing task by ID
async function updateProduct(id, product) {
    await fetch(`${apiBaseUrl}/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(product)
    });
}

// Delete a task by ID
async function deleteProduct(id) {
    await fetch(`${apiBaseUrl}/${id}`, {
        method: 'DELETE'
    });
}

// Get a single task by ID
async function getProductById(id) {
    const response = await fetch(`${apiBaseUrl}/${id}`);
    return response.json();
}
