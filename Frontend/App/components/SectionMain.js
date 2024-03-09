export function SectionMain() {
    const $section = document.createElement("section");

    $section.classList.add("home-page");
    $section.innerHTML = `
        <article>
            <div>
                <h1>The platform where you plan the tasks of the day.</h1>

                <p>This application works for organizing your day-to-day activities, creating projects and tasks as needed, and allowing you to schedule deadlines for the tasks.</p>
            </div>
            <!--IMAGENES-->
            <div class="img-task">
                <img src="./App/assets/undraw_designer_re_5v95.svg" alt="man resolving the task"/>
            </div>
        </article>

        <section class="features">
            <h2>-- Key Features --</h2>

            <ul>
                <li>
                    <strong>Project Creation</strong>
                    <p>Easily create projects to organize your tasks and initiatives.</p>
                </li>
                <li>
                    <strong>Deadline Setting</strong>
                    <p>Set deadlines for tasks and projects to ensure timely completion and project management.</p>
                </li>
                <li>
                    <strong>Progress Tracking</strong>
                    <p>Track the progress of your projects and tasks in real-time to stay on top of your goals and objectives.</p>
                </li>
                <li>
                    <strong>Customization Options</strong>
                    <p>Customize your workspace and task lists to fit your unique workflow and preferences.</p>
                </li>
                <li>
                    <strong>User-Friendly Interface</strong>
                    <p>Enjoy a user-friendly interface that makes project and task management simple and intuitive for all users.</p>
                </li>
                <li>
                    <strong>Data Security</strong>
                    <p>Rest assured that your data is safe and secure with our robust security measures and encryption protocols.</p>
                </li>
            </ul>
        </section>

        <section class="cta">
            <hr/>
            <div class="cta-container">
                <h2>Ready to Get Organized?</h2>
                <p>Sign up now to start organizing your projects, managing tasks, and boosting productivity with our platform.</p>
                <a href="#/sing-up">Sign Up for Free</a>
            </div>
            <hr/>
        </section>
    `;

    return $section;
}