// pages/login.js
'use client'
import { useState } from 'react';
import { useRouter } from 'next/navigation';
import { toast } from 'react-toastify';

const Create = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [userId, setUserId] = useState(null);
    const router = useRouter();

    const handleLogin = async (e) => {
        e.preventDefault();
        console.log('handlelistingcreate')
        try {
            const response = await fetch('http://localhost:8081/api/v1/listings', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(
                    {
                        "userId": 2,
                        "price" : 2562.0,
                        "photo" : "https://www.redfin.com/blog/wp-content/uploads/2019/10/1_How-to-Set-Up-Your-Home-as-a-Rental-Property.jpg",
                        "title": "Yazlık ev",
                        "description": "Bu ev tam yazlık.",
                        "netArea": 120,
                        "grossArea": 150,
                        "builtIn": 2005,
                        "heatingType": "AIR_CONDITIONER",
                        "bathroom": 2,
                        "bedroom": 3,
                        "propertyType": "SUMMER_HOUSE",
                        "listingType": "RENTAL",
                        "address": {
                            "city": "BALIKESİR",
                            "country": "TURKIYE",
                            "zipCode": "36545",
                            "state": "AYVALIK",
                            "street": "GUNDOGAN",
                            "blockNumber": 10,
                            "floorNumber": 5,
                            "flatNumber": 101
                        }
                    })
                ,
            });
            const res = await response.json();
            console.log('resjson:', JSON.stringify(res, null, 2)); // Improved logging

            if (response.ok) {
                console.log('ok');
                if (res.status ==='SUCCESS') {
                    console.log('success');
                    setUserId(data.id); // Assuming response.data.id contains the user ID
                    toast.success('Login successful!');
                    return router.push('/deneme');
                } else {
                    toast.error('Login failed: ' + (data.message || 'Unknown error'));
                }
            } else {
                toast.error('Login failed: ' + (data.message || 'Unknown error'));
            }
        } catch (error) {
            toast.error('An error occurred: ' + (error.message || 'Unknown error'));
        }
    };

    return (
        <div>
            <h1>Login</h1>
            <form onSubmit={handleLogin}>
                <div>
                    <label>Email:</label>
                    <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
                </div>
                <div>
                    <label>Password:</label>
                    <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} required />
                </div>
                <button type="submit">Login</button>
            </form>
            {userId && <p>User ID: {userId}</p>}
        </div>
    );
};

export default Create;
