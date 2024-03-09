export function regExp(inputs) {
  let inputsLength = inputs.length,
    count = 0;

  inputs.forEach(($input) => {
    if (new RegExp($input.dataset.pattern).test($input.value)) {
      count++;
      return;
    }

    let $span = document.createElement("span");
    $span.innerText = "Complete correctly the field.";
    //console.log($input.nextElementSibling);

    if (!$input.nextElementSibling) $input.after($span);
  });

  if (inputsLength === count) {
    return true;
  } else {
    return false;
  }
}
