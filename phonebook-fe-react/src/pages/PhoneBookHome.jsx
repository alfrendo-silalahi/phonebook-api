import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

export default function PhoneBookHome() {
  const [contacts, setContacts] = useState([]);
  const [lastPage, setLastpage] = useState(false);
  const [page, setPage] = useState(1);
  const [search, setSearch] = useState("");

  function previousPageHandler() {
    setPage((currentPage) => {
      if (currentPage === 1) {
        return currentPage;
      } else {
        const previousPage = currentPage - 1;
        fetchContactsHandler(previousPage, search);
        return previousPage;
      }
    });
  }

  function nextPageHandler() {
    setPage((currentPage) => {
      if (lastPage) {
        return currentPage;
      } else {
        const nextPage = currentPage + 1;
        fetchContactsHandler(nextPage, search);
        return nextPage;
      }
    });
  }

  function fetchContactsHandler(pageNum, search) {
    let url;
    if (search === "") {
      url = `http://localhost:8080/api/v1/contacts?page=${pageNum}`;
    } else {
      url = `http://localhost:8080/api/v1/contacts?page=${pageNum}&search=${search}`;
    }
    axios.get(url).then((res) => {
      const data = res.data.data;
      setContacts(() => data.contacts);
      setLastpage(() => data.lastPage);
    });
  }

  function searchInputHandler(e) {
    console.log(e.target.value);
    setSearch(e.target.value);
  }

  function submitSearchHandler(e) {
    e.preventDefault();
    setPage(1);
    fetchContactsHandler(1, search);
  }

  function deleteContactHandler(id) {
    axios.delete(`http://localhost:8080/api/v1/contacts/${id}`).then((res) => {
      console.log(res.data);
      fetchContactsHandler(page, search);
    });
  }

  useEffect(() => {
    fetchContactsHandler(page, search);
  }, []);

  return (
    <div className="container mt-5">
      <h1>Phone Book</h1>
      <form onSubmit={submitSearchHandler}>
        <div className="mb-3">
          <label className="form-label">Search by Name</label>
          <input
            type="text"
            value={search}
            onChange={searchInputHandler}
            className="form-control"
          />
        </div>
        <button type="submit" className="btn btn-sm btn-primary">
          Search
        </button>
      </form>
      <table className="table">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Phone Number</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
          {contacts.map((contact, index) => (
            <tr key={contact.id}>
              <th scope="row">{index + 1 + (page - 1) * 5}</th>
              <td>{contact.name}</td>
              <td>{contact.phoneNumber}</td>
              <td>
                <Link
                  to={`/contact/${contact.id}`}
                  className="btn btn-sm btn-success mx-1"
                >
                  Detail
                </Link>
                <button
                  onClick={() => deleteContactHandler(contact.id)}
                  className="btn btn-sm btn-danger"
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <nav aria-label="Page navigation example">
        <ul className="pagination">
          <li className="page-item">
            {page === 1 ? (
              <button
                onClick={previousPageHandler}
                className="page-link bg-secondary text-white"
              >
                Previous
              </button>
            ) : (
              <button onClick={previousPageHandler} className="page-link">
                Previous
              </button>
            )}
          </li>
          <li className="page-item">
            <p className="page-link" href="#">
              {page}
            </p>
          </li>
          <li className="page-item">
            {lastPage ? (
              <button
                disabled
                onClick={nextPageHandler}
                className="page-link bg-secondary text-white"
              >
                Next
              </button>
            ) : (
              <button onClick={nextPageHandler} className="page-link">
                Next
              </button>
            )}
          </li>
        </ul>
      </nav>
    </div>
  );
}
