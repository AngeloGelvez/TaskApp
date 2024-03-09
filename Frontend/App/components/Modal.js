export function Modal(message) {
    const $aside = document.createElement("aside");

    $aside.classList.add("view-modal");

    $aside.innerHTML = `
        <div>
            <h4>${message}</h4>
        </div>
    `;

    return $aside;
}