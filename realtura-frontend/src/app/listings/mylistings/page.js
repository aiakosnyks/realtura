'use client'

import ListingCard from "@/app/components/ListingCard";
import styles from './page.module.css'
import {useAuth} from "@/app/context/AuthContext";
import {useEffect, useState} from "react";

const page = 0;
const size = 10;


const Dashboard = () => {
    const { userId } = useAuth();
    const [listings, setListings] = useState([])

    useEffect( () => {
        const fetchListings = async () => {

            try {
                const response = await fetch('http://localhost:8081/api/v1/listings/getAllByFilter', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({ page, size, userId: userId }),
                });
                const res =await response.json();
                setListings(res.data)
                console.log('listings:', JSON.stringify(res.data, null, 2)); // Improved logging
            } catch (error) {
                console.error('Error fetching listings:', error);
            }
        };
        fetchListings();
    }, []);

    console.log(listings);
    return (
        <div className={styles.main} >
            <div className={styles.card}>
                {listings && listings.map((listing) => (
                    <ListingCard key={listing.id} listing={listing} />
                ))}
            </div>

        </div>
    );
};

export default Dashboard;
