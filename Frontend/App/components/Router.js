import { Home } from "./Home.js";
import { Login } from "./Login.js";
import { Project } from "./Project.js";
import { Register } from "./Register.js";
import { SectionMain } from "./SectionMain.js";
import { FormProject } from "./FormProject.js";
import { CardProject } from "./CardProject.js";
import api from "../helpers/api.js";
import { ajax } from "../helpers/ajax.js";
import { EditProject } from "./EditProject.js";
import { InfoProject } from "./InfoProject.js";

export function Router() {
  let hash = location.hash;
  const $main = document.querySelector(".content");
  const { id } = JSON.parse(localStorage.getItem("user"));
  const  idProject  = localStorage.getItem("project");
  //console.log(hash);

  if (!hash || hash === "#/") {
    $main.appendChild(SectionMain());
  } else if (hash === "#/sing-up") {
    $main.appendChild(Login());
  } else if (hash === "#/register") {
    $main.appendChild(Register());
  } else if (hash === "#/home") {
    $main.appendChild(Home());
  } else if (hash === "#/projects") {
    $main.appendChild(Project());

    const fragment = document.createDocumentFragment();
    ajax({
      method: "GET",
      url: `${api.PROJECTS}/${id}`,
      cbSuccess: (projects) => {
        projects.forEach((project) => {
          fragment.appendChild(CardProject(project));
        });

        $main.appendChild(fragment);
      },
    });
  } else if (hash === "#/create-project") {
    $main.appendChild(FormProject());
  } else if (hash === "#/edit-project") {

    ajax({
      method: "GET",
      url: `${api.PROJECTS}/${id}/${idProject}`,
      cbSuccess(data) {
        $main.appendChild(EditProject(data));
      }
    });

  }else if(hash == "#/projects#/task") {

    ajax({
      method: "GET",
      url: `${api.PROJECTS}/${id}/${idProject}`,
      cbSuccess(data) {
        $main.appendChild(InfoProject(data));
      }
    });

  }
}
