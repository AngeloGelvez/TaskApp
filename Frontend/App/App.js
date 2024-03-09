import { Footer } from "./components/Footer.js";
import { Main } from "./components/Main.js";
import { Menu } from "./components/Menu.js";
import { Router } from "./components/Router.js";

export function App() {
    const $root = document.getElementById("root");

    $root.innerHTML = null;

    $root.appendChild(Menu());
    $root.appendChild(Main());
    $root.appendChild(Footer());

    Router();
}