export function Menu() {
    const $nav = document.createElement("nav");
    let name = "";

    if(localStorage.getItem("user")) name = JSON.parse(localStorage.getItem("user")).name;

    $nav.classList.add("navigator");

    $nav.innerHTML = `
        <ul class="list">
            <div class="icon">
                <li><i class="fa-solid fa-list-check"></i><a href="#/">Task App</a></li>
            </div>
            
            <div class="options">
                ${(name)
                ? `
                <li><a href="#/home">Home</a></li>
                <li><a href="#/projects">Projects</a></li>
                <li><a href="#/">My Tasks</a></li>` + "<li><a href='#/user'><i class='fa-solid fa-user'>ㅤ</i> "+ name +"</a></li>"
                
                :`
                <li><a href="#/sing-up">Sign Up</a></li>
                <li id="register"><a href="#/register">Register</a></li>
                `}
                
            </div>
        </ul>
    `;

    return $nav;
}