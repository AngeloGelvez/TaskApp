export function Register() {
    /*
        name
        email
        password
        phone
    */

    const $div = document.createElement("div");
    const $form = document.createElement("form");
    $div.appendChild($form);
    $div.classList.add("container");
    $form.classList.add("form-aut");

    $form.innerHTML = `
        <h2>Register With Us</h2>

        <div>
            <label for="name">Name</label>
            <input id="name" type="text" name="name" placeholder="example" data-pattern="^[A-Za-z]+$">
        </div>

        <div>
            <label for="email">Email</label>
            <input id="email" type="email" name="email" placeholder="example@hotmail.com" placeholder="example@hotmail.com" data-pattern="^[a-z0-9]+([._][a-z0-9]+)*@[a-z0-9-]+(\.[a-z]{2,15}){1,2}$">
        </div>

        <div>
            <label for="pass">Password</label>
            <input id="pass" type="password" name="password" placeholder="●●●●●●●●●" data-pattern=".{9,}">
        </div>

        <div>
            <label for="phone">Number Phone</label>
            <input id="phone" type="text" name="phone" placeholder="1234567890" data-pattern="^[0-9]{9,}$">
        </div>

        <button type="submit" class="register">Send Form</button>
    `;

    return $div;
}