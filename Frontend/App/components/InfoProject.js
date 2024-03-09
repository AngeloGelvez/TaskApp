export function InfoProject(props) {
  let { id, name, description, tag, startDate, endDate, color } = props;
  const $section = document.createElement("section");

  $section.classList.add("info-project");
  $section.innerHTML = `
    <div class="banner" style="background-color:${color};">
    With order and time you will find the secret to doing everything, and doing it well
    </div>
    <div class="info-content">
      <aside>
        <ul>
          <li><strong>Tag:</strong> ${tag}</li>
          <li><strong>Start Date:</strong> ${startDate}</li>
          <li><strong>End Date:</strong> ${endDate}</li>
        </ul>
      </aside>
      <div>
        <h1>${name}</h1>
        <p>${description}</p>
        <section> Van mis tareas </section>
      </div>
    </div>
    

  `;

  return $section;
}