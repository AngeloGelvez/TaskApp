export function Footer() {
  const $footer = document.createElement("footer");

  $footer.classList.add("footer");

  $footer.innerHTML = `
    <div class="container-f">
        <div class="row">
            <div class="icon">
                <i class="fa-solid fa-list-check"></i>
                <span class="fs-5">Task App</span>
            </div>

            <div class="col-f">
                <h5>Links</h5>
                <ul class="list-unstyled">
                <li class="mb-2"><a href="/">Home</a></li>
                <li class="mb-2"><a href="/docs/5.3/">Docs</a></li>
                <li class="mb-2"><a href="/docs/5.3/examples/">Examples</a></li>
                <li class="mb-2"><a href="https://icons.getbootstrap.com/">Icons</a></li>
                <li class="mb-2"><a href="https://themes.getbootstrap.com/">Themes</a></li>
                <li class="mb-2"><a href="https://blog.getbootstrap.com/">Blog</a></li>
                <li class="mb-2"><a href="https://cottonbureau.com/people/bootstrap" target="_blank" rel="noopener">Swag Store</a></li>
                </ul>
            </div>

            <div class="col-f">
                <h5>Guides</h5>
                <ul class="list-unstyled">
                <li class="mb-2"><a href="/docs/5.3/getting-started/">Getting started</a></li>
                <li class="mb-2"><a href="/docs/5.3/examples/starter-template/">Starter template</a></li>
                <li class="mb-2"><a href="/docs/5.3/getting-started/webpack/">Webpack</a></li>
                <li class="mb-2"><a href="/docs/5.3/getting-started/parcel/">Parcel</a></li>
                <li class="mb-2"><a href="/docs/5.3/getting-started/vite/">Vite</a></li>
                </ul>
            </div>

            <div class="col-f">
                <h5>Projects</h5>
                <ul class="list-unstyled">
                <li class="mb-2"><a href="https://github.com/twbs/bootstrap" target="_blank" rel="noopener">Bootstrap 5</a></li>
                <li class="mb-2"><a href="https://github.com/twbs/bootstrap/tree/v4-dev" target="_blank" rel="noopener">Bootstrap 4</a></li>
                <li class="mb-2"><a href="https://github.com/twbs/icons" target="_blank" rel="noopener">Icons</a></li>
                <li class="mb-2"><a href="https://github.com/twbs/rfs" target="_blank" rel="noopener">RFS</a></li>
                <li class="mb-2"><a href="https://github.com/twbs/examples/" target="_blank" rel="noopener">Examples repo</a></li>
                </ul>
            </div>

            <div class="col-f">
                <h5>Community</h5>
                <ul class="list-unstyled">
                <li class="mb-2"><a href="https://github.com/twbs/bootstrap/issues" target="_blank" rel="noopener">Issues</a></li>
                <li class="mb-2"><a href="https://github.com/twbs/bootstrap/discussions" target="_blank" rel="noopener">Discussions</a></li>
                <li class="mb-2"><a href="https://github.com/sponsors/twbs" target="_blank" rel="noopener">Corporate sponsors</a></li>
                <li class="mb-2"><a href="https://opencollective.com/bootstrap" target="_blank" rel="noopener">Open Collective</a></li>
                <li class="mb-2"><a href="https://stackoverflow.com/questions/tagged/bootstrap-5" target="_blank" rel="noopener">Stack Overflow</a></li>
                </ul>
            </div>
        </div>
    </div>
    `;
  return $footer;
}
