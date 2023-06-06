

<div class="modal fade" id="addProductModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="staticBackdropLabel">Add a product</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="addProduct" method="post" enctype="multipart/form-data">
                    <div class="mb-3">
                        <label for="productName" class="form-label">Name</label>
                        <input type="text" class="form-control" id="productName" name="productName" required>
                    </div>
                    <div class="mb-3">
                        <label for="productDescription" class="form-label">Description</label>
                        <textarea class="form-control" id="productDescription" name="productDescription" required></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="productPrice" class="form-label">Price</label>
                        <input type="number" step="0.01" class="form-control" id="productPrice" name="productPrice" required>
                    </div>
                    <div class="mb-3">
                        <label for="era" class="form-label">Era</label>
                        <select class="form-select" id="era" name="era" required>
                            <option value="">Select Era</option>
                            <option value="Victorian">Victorian</option>
                            <option value="Regency">Regency</option>
                            <option value="Edwardian">Edwardian</option>
                            <option value="Elizabethan">Elizabethan</option>
                            <option value="Century18">18th Century</option>
                            <option value="Tudor">Tudor</option>
                            <option value="Modern">Modern</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="type" class="form-label">Type</label>
                        <select class="form-select" id="type" name="type" required>
                            <option value="">Select Type</option>
                            <option value="CorsetOverbust">Corset Overbust</option>
                            <option value="CorsetUnderbust">Corset Underbust</option>
                            <option value="CorsetBelt">Corset Belt</option>
                            <option value="UnderbustBodice">Underbust Bodice</option>
                            <option value="Stay">Stay</option>
                            <option value="Supplies">Supplies</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="imageUrl">Image URL:</label>
                        <input type="text" class="form-control" id="imageUrl" name="imageUrl" placeholder="Enter image URL">
                    </div>

<%--                    <div class="divider d-flex align-items-center my-4">--%>
<%--                        <p class="text-center fw-bold mx-3 mb-0 text-muted">OR</p>--%>
<%--                    </div>--%>

<%--                    <div class="form-group">--%>
<%--                        <label for="imageUpload">Image Upload:</label>--%>
<%--                        <input type="file" class="form-control" id="imageUpload" name="imageUpload">--%>
<%--                    </div>--%>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" value="/addProduct" class="btn btn-primary">Add product</button>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>
