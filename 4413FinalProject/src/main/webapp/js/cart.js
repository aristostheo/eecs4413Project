/**
 * 
 */

document.querySelector('#updateForm input[type="number"]').addEventListener('input', function() {
	document.getElementById('updateForm').submit();
});

function update() {
        // Get the form
        const form = document.getElementById('updateForm');
        
        // Submit the form
        form.submit();
    }