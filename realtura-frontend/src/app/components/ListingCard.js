// src/components/ListingCard.js

import {Card, CardBody, CardHeader} from "@nextui-org/card";
import Modal from "@/app/components/Modal";
import Image from 'next/image';
import {useState} from "react";
import {toast} from "react-toastify"; // Ensure you're importing the Image component

const ListingCard = ({ listing }) => {
    const [status, setStatus] = useState(listing.isActive)
    const { country, city, state } = listing.address;
    const location = `${country.toUpperCase()}, ${city}, ${state}`;
    console.log(listing);

    const handleDelete = async () => {
        try {
            console.log('Success2:');
            const response = await fetch('http://localhost:8081/api/v1/listings/delete/' + listing.id, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(values),
            });
            console.log('Success3');

            const res = await response.json();
            console.log('resjson:', JSON.stringify(res, null, 2)); // Improved logging

            if (response.ok) {
                console.log('ok');
                if (res.status === 'SUCCESS') {
                    console.log('success');
                    toast.success('Login successful!');
                } else {
                    toast.error('Login failed: ' + (data.message || 'Unknown error'));
                }
            } else {
                toast.error('Login failed: ' + (data.message || 'Unknown error'));
            }
        } catch (error) {
            toast.error('An error occurred: ' + (error.message || 'Unknown error'));
        }
    }

        return (
        <div style={{display: "flex"}}>
            <Card className="py-4">
                <CardHeader className="pb-0 pt-2 px-4 flex-col items-start">
                    <p className="text-tiny uppercase font-bold">{location}</p>
                    <small className="text-default-500">{listing.price}</small>
                    <h4 className="font-bold text-large">{listing.title}</h4>
                </CardHeader>
                <CardBody className="overflow-visible py-2">
                    {/* eslint-disable-next-line react/jsx-no-undef */}
                    <Image
                        alt="Card background"
                        className="object-cover rounded-xl"
                        src={listing.photo}
                        width={270}
                        height={180}
                    />
                </CardBody>
            </Card>
            <button onClick={handleEdit}>Düzenle</button>
            <button onClick={handleDelete}>Sil</button>
            <button onClick={handleStatus}>{$status}</button>
        </div>
    );
};


export default ListingCard;

