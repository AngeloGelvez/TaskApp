export function Login() {
    const $div = document.createElement("div");
    const $form = document.createElement("form");
    $div.appendChild($form);
    $div.classList.add("container");
    $form.classList.add("form-aut");

    $form.innerHTML = `
        <h2>Sing Up</h2>

        <div>
            <label for="email">Email</label>
            <input id="email" type="email" name="email" placeholder="example@hotmail.com" data-pattern="^[A-Za-z0-9]+([._][A-Za-z0-9]+)*@[A-Za-z0-9-]+(\.[a-zA-Z]{2,15}){1,2}$">
        </div>

        <div>
            <label for="pass">Password</label>
            <input id="pass" type="password" name="password" placeholder="●●●●●●●●●" data-pattern=".{9,}">
        </div>

        <button type="submit" class="login">Send Form</button>
    `;

    return $div;
}