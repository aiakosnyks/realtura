// src/components/ListingCard.js

import {Card, CardBody, CardHeader} from "@nextui-org/card";
import Modal from "@/app/components/Modal";
import Image from 'next/image'; // Ensure you're importing the Image component

const ListingCard = ({ listing }) => {
    const { country, city, state } = listing.address;
    const location = `${country.toUpperCase()}, ${city}, ${state}`;
    console.log(listing);
    return (
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
    );
};

export default ListingCard;

