/**
 * 
 */

function closeSuccessMessage() {
    const message = document.getElementById('successMessage');
    if (message) {
        message.classList.add('hidden');

        // Optional: Remove the element after animation completes
        setTimeout(() => {
            if (message) {
                message.remove(); // Remove the element from the DOM
            }
        }, 500); // Match the duration of the CSS transition
    }
}