function goToMain(){
    window.location.href = "../index.html";
}

function newNotePage(){
    window.location.href = "../views/note.html";
}

function editwNotePage(){
    window.location.href = "../views/note.html";
    // Consultar el API y sobreescribir el espacio de los inputs
}

function viewNote(){
    window.location.href = "../views/view.html";
}

function autoResize(textarea){
    textarea.style.height = 'auto';
    textarea.style.height = textarea.scrollHeight + 'px';
}

function toggleInfo() {
    const popupOverlay = document.getElementById('popupOverlay');
    const popup = document.getElementById('popup');

    function openPopup() {
        popupOverlay.style.display = 'flex'; // Set display to flex
        // Use a timeout to allow the display to take effect before setting opacity
        setTimeout(() => {
            popupOverlay.style.opacity = 1; // Fade in
        }, 10); // Small timeout to trigger the transition
    }

    function closePopupFunc() {
        popupOverlay.style.opacity = 0; // Fade out
        // Wait for the transition to finish before setting display to none
        popupOverlay.addEventListener('transitionend', function() {
            popupOverlay.style.display = 'none'; // Set display to none after fading out
        }, { once: true });
    }

    // Open the popup immediately when the function is called
    openPopup();

    // Close the popup when clicking the overlay or the close button (if it exists)
    popupOverlay.addEventListener('click', function (event) {
        if (event.target === popupOverlay) {
            closePopupFunc();
        }
    });

    // Optional close button
    const closeButton = document.getElementById('closePopup');
    if (closeButton) {
        closeButton.addEventListener('click', closePopupFunc);
    }
}