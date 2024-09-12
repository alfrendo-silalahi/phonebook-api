import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import PhoneBookHome from "./pages/PhoneBookHome.jsx";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import ContactDetail from "./pages/ContactDetail.jsx";

const router = createBrowserRouter([
  {
    path: "/",
    element: <PhoneBookHome />,
  },
  {
    path: "/contact/:id",
    element: <ContactDetail />,
  },
]);

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <RouterProvider router={router} />
  </StrictMode>
);
