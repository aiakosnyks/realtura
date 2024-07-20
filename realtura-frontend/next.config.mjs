/** @type {import('next').NextConfig} */
const nextConfig = {
    images: {
        remotePatterns: [
            {
                protocol: 'https',
                hostname: 'nextui.org',
                pathname: '/images/**',
            },
            {
                protocol: 'https',
                hostname: 'media-cdn.tripadvisor.com',
                pathname: '/media/vr-splice-j/**',
            },
            {
                protocol: 'https',
                hostname: 'www.redfin.com',
                pathname: '/blog/wp-content/uploads/**',
            },
        ],
    },
};

export default nextConfig;
