import axios from "axios";
import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";

export default function ContactDetail() {
  const { id } = useParams();
  const [contactDetail, setContactDetail] = useState({});

  useEffect(() => {
    axios.get(`http://localhost:8080/api/v1/contacts/${id}`).then((res) => {
      const contact = res.data.data.contact;
      console.log(contact);
      setContactDetail(contact);
    });
  }, []);

  return (
    <div className="container mt-5">
      <h2 className="mb-4">Contact Details</h2>
      <table className="table table-striped table-bordered">
        <tbody>
          <tr>
            <th scope="row">ID</th>
            <td>{contactDetail.id}</td>
          </tr>
          <tr>
            <th scope="row">Name</th>
            <td>{contactDetail.name}</td>
          </tr>
          <tr>
            <th scope="row">Phone Number</th>
            <td>{contactDetail.phoneNumber}</td>
          </tr>
          <tr>
            <th scope="row">Email</th>
            <td>{contactDetail.email}</td>
          </tr>
          <tr>
            <th scope="row">Address</th>
            <td>{contactDetail.address}</td>
          </tr>
          <tr>
            <th scope="row">Notes</th>
            <td>{contactDetail.notes}</td>
          </tr>
          <tr>
            <th scope="row">Created At</th>
            <td>{contactDetail.createdAt}</td>
          </tr>
          <tr>
            <th scope="row">Updated At</th>
            <td>{contactDetail.updatedAt}</td>
          </tr>
        </tbody>
      </table>
      <Link className="btn btn-sm btn-primary" to={"/"}>
        Back to Home
      </Link>
    </div>
  );
}
