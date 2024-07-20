import Image from "next/image";
import styles from "./page.module.css";
import Login from "@/app/login/page";
import Listings from "@/app/listings/page";

export default function Home() {
  const isLoggedIn = false;
  const renderHome = () => {
    if(isLoggedIn) {
      return <Listings></Listings>
    }
    return <Login></Login>
  }
  return (
    <>
      {renderHome()}
    </>
  );
}
