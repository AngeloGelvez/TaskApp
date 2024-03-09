export function FormProject() {
  const $section = document.createElement("section");

  $section.classList.add("create-form");

  $section.innerHTML = `
        <h1>Great!!! Starting a New Project</h1>

        <form id="projectForm">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <textarea id="description" name="description" rows="4" required></textarea>
            </div>
            <div class="form-group">
                <label for="startDate">Start Date:</label>
                <input type="date" id="startDate" name="startDate" required>
            </div>
            <div class="form-group">
                <label for="endDate">End Date:</label>
                <input type="date" id="endDate" name="endDate" required>
            </div>
            <div class="form-group">
                <label for="tag">Tag:</label>
                <input type="text" id="tag" name="tag" required>
            </div>
            <div class="form-group">
                <label for="color">Color:</label>
                <input type="color" id="color" name="color" value="#FFFFFF" required>
            </div>

            <button type="submit" class="create-project">Create Project</button>
        </form>
    `;

  return $section;
}
