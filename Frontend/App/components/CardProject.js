export function CardProject(props) {
  let { id, name, description, tag, color, startDate, endDate } = props;

  //console.log(startDate);

  const $section = document.createElement("section");
  
  $section.classList.add("card");
  $section.classList.add("card-href");
  $section.style.borderLeft = `5px solid ${color}`;
  $section.innerHTML = `
        <div class="card-href">
            <h2 class="card-href">${name}</h2>
            <p class="card-href">${description}</p>
            <span class="card-href"> ${tag} | Start Date: ${startDate[2]}/${startDate[1]}/${startDate[0]}</span>
        </div>
        
        <i class="fa-solid fa-ellipsis-vertical options-project" id=${id}></i>

        <div class="modal-options visible" id="modal-${id}">
          <ul>
            <li><a href="#/edit-project" class="btn-edit" data-obj='${id}'>Edit</a></li>
            <li><a href="#" style="color:#c84648;">Delete</a></li>
          </ul>
        </div>
    `;

  return $section;
}
