'use client';
import { useState, useEffect } from 'react';
import Modal from '../components/Modal';
import ListingCard from '../components/ListingCard'; // Adjusted to reflect the correct component name

const Dashboard = () => {
    const [listings, setListings] = useState([]);
    const [showModal, setShowModal] = useState(false);

    useEffect(() => {
        // Fetch listings from API
        const fetchListings = async () => {
            try {
                const response = await fetch('/api/v1/listings'); // Adjust the endpoint as needed
                const data = await response.json();
                setListings(data.data); // Assuming data contains the listings in the `data` field
            } catch (error) {
                console.error('Error fetching listings:', error);
            }
        };

        fetchListings();
    }, []);

    const handleCreateAd = (newListing) => {
        setListings([...listings, newListing]);
        setShowModal(false);
    };

    return (
        <div className="container mx-auto">
            <h1 className="my-4 text-3xl font-bold">İlanlar</h1>
            <button
                onClick={() => setShowModal(true)}
                className="px-4 py-2 text-white bg-blue-500 rounded"
            >
                Yeni İlan Oluştur
            </button>
            <div className="grid grid-cols-1 gap-4 md:grid-cols-2 lg:grid-cols-3">
                {listings.map((listing) => (
                    <ListingCard key={listing.id} ad={listing} />
                ))}
            </div>
            {showModal && (
                <Modal
                    onClose={() => setShowModal(false)}
                    onCreateAd={handleCreateAd}
                />
            )}
        </div>
    );
};

export default Dashboard;
