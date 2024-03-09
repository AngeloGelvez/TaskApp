import { App } from "./App.js";
import { ajax } from "./helpers/ajax.js";
import api from "./helpers/api.js";
import { Modal } from "./components/Modal.js";
import { regExp } from "./helpers/reg_exp.js";

document.addEventListener("DOMContentLoaded", App);
window.addEventListener("hashchange", App);

//EVENTOS SI ACTUA EL CLICK
document.addEventListener("click", (e) => {
  const $form = document.querySelector(".form-aut");
  const $main = document.querySelector(".content");
  let $inputs = document.querySelectorAll(".form-aut input");

  //LOGIN
  if (e.target.matches(".login")) {
    e.preventDefault();

    if (!regExp($inputs)) return false;

    ajax({
      url: `${api.USER}/login`,
      method: "POST",
      body: JSON.stringify({
        email: $form.email.value,
        password: $form.password.value,
      }),
      cbSuccess: (response) => {
        //console.log(response);
        localStorage.setItem("user", JSON.stringify(response));

        window.location.href = "#/home";

        if (response.mensaje === null) {
          $main.appendChild(Modal(response.mensaje));
        }
      },
    });
  }

  //REGISTER
  if (e.target.matches(".register")) {
    e.preventDefault();

    if (!regExp($inputs)) return false;

    ajax({
      url: `${api.USER}/register`,
      method: "POST",
      body: JSON.stringify({
        name: $form.name.value,
        email: $form.email.value,
        password: $form.password.value,
        phone: $form.phone.value,
      }),
      cbSuccess: (response) => {
        console.log(response);

        if (response.mensaje === null) {
          $main.appendChild(Modal(response.mensaje));
        }
      },
    });
  }

  //CREATE PROJECT
  if(e.target.matches(".create-project")) {
    e.preventDefault();

    const { id } = JSON.parse(localStorage.getItem("user"));
    const $formProject = document.getElementById("projectForm");

    ajax({
      url: `${api.PROJECTS}/${id}`,
      method: "POST",
      body: JSON.stringify({
        name: $formProject.name.value,
        description: $formProject.description.value,
        startDate: $formProject.startDate.value,
        endDate: $formProject.endDate.value,
        tag: $formProject.tag.value,
        color: $formProject.color.value,
      }),
      cbSuccess: (response) => {
        console.log(response);

        if (response.mensaje === null) {
          $main.appendChild(Modal(response.mensaje));
        }

        window.location.href = "#/projects";
      },
    });
  }

  //OPTIONS PROJECTS
  if(e.target.matches(".options-project")) {
    const $modal = document.getElementById(`modal-${e.target.id}`);

    $modal.classList.toggle("visible");
  }

  //OPTIONS PROJECTS EDIT
  if(e.target.matches(".btn-edit")) {
    localStorage.setItem("project", e.target.dataset.obj);
  }

  //EDIT PROJECT
  if(e.target.matches(".edit-project")) {
    e.preventDefault();

    const id = JSON.parse(localStorage.getItem("project"));
    const $formProject = document.getElementById("projectForm");

    ajax({
      url: `${api.PROJECTS}/${id}`,
      method: "PUT",
      body: JSON.stringify({
        name: $formProject.name.value,
        description: $formProject.description.value,
        startDate: $formProject.startDate.value,
        endDate: $formProject.endDate.value,
        tag: $formProject.tag.value,
        color: $formProject.color.value,
      }),
      cbSuccess: (response) => {
        console.log(response);

        if (response.mensaje === null) {
          $main.appendChild(Modal(response.mensaje));
        }

        window.location.href = "#/projects";
      },
    });
  }
  
  if(e.target.matches(".card-href")) {
    const id = e.target;

    console.log(id);
    //localStorage.setItem("project", id);
    location.href = "#/projects#/task";
  }
});
