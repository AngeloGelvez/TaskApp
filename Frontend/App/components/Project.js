export function Project() {
    const $div = document.createElement("div");

    $div.classList.add("projects");
    $div.innerHTML = `
        <div>
            <h1>Projects</h1>

            <a href="#/create-project"><i class="fa-solid fa-plus"></i></a>
        </div>

        <hr/>
    `;

    return $div;
}