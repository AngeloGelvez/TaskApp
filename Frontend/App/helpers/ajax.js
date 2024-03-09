import { Modal } from "../components/Modal.js";

export async function ajax(props) {
  const { method, cbSuccess, url, body = null } = props;

  try {
    let response = await fetch(url, {
      method,
      headers: {
        "content-type": "application/json; charset=utf-8",
      },
      body,
    });

    let data = await response.json();

    if (response.ok) {
      cbSuccess(data);
      return false;
    }

    throw data;
  } catch (error) {
    console.log(error);
  }
}
