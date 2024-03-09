export function Home() {
    const $section = document.createElement("section");
    $section.classList.add("home");

    $section.innerHTML = `
        <h1>Welcome to Project Manager</h1>

        <div id="home-main">
            <aside class="block-p">
                <h2>My Projects</h2>
                <p>Manage all your projects efficiently.</p>
                <br/>
                <button class="btn-pro"> 
                    <a href="#/projects">View Projects</a>
                </button> 
                <br/>
            </aside>

            <aside class="block-t">
                <h2>My Tasks</h2>
                <p>Organize your tasks and stay productive.</p>
                <br/>
                <button class="btn-task"> 
                    <a href="#/task">View Tasks</a>
                </button> 
            </aside>

            <aside class="block-pro">
                <h2>Profile</h2>
                <p>Manage your account settings and preferences.</p>
                <br/>
                <button class="btn-p"> 
                    <a href="#/profile">View Profile</a>
                </button> 
            </aside>
        </div>

        
    `;

    return $section;
}