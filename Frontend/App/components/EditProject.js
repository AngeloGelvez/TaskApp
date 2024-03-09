export function EditProject(props) {
  let { id, name, description, tag, color, startDate, endDate } = props;

  const $section = document.createElement("section");

  $section.classList.add("create-form");

  $section.innerHTML = `
        <h1>Edit Your Project</h1>

        <form id="projectForm">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required value="${name}">
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <textarea id="description" name="description" rows="4" required value="${description}" placeholder="${description}"></textarea>
            </div>
            <div class="form-group">
                <label for="startDate">Start Date:</label>
                <input type="date" id="startDate" name="startDate" required value="${startDate}" placeholder="${startDate}">
            </div>
            <div class="form-group">
                <label for="endDate">End Date:</label>
                <input type="date" id="endDate" name="endDate" required value="${endDate}" placeholder="${endDate}">
            </div>
            <div class="form-group">
                <label for="tag">Tag:</label>
                <input type="text" id="tag" name="tag" required value="${tag}" placeholder="${tag}">
            </div>
            <div class="form-group">
                <label for="color">Color:</label>
                <input type="color" id="color" name="color" required value="${color}" placeholder="${color}">
            </div>

            <button type="submit" class="edit-project">Edit The Project</button>
        </form>
    `;

  return $section;
}