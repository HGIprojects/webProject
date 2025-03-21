const pics = [
	"/myAssets/images/20241124-L1001066.jpg",
	"/myAssets/images/20250104-L1001143.jpg",
	"/myAssets/images/IMG_2167.jpg"
];

const randomIndex = Math.floor(Math.random() * pics.length);
const selectedImage = pics[randomIndex];
console.log("Image number " + randomIndex + " randomly selected");
document.getElementById("randomPick").src = selectedImage;