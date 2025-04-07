package com.example.croptrack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

//data class Crops{
//    val name: String,
//    val description: String,
//    val image: Int,
//    val location: String,
//    val area: String,
//}
class CropDescription : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crop_description, container, false)

        val cropName = arguments?.getString("cropName")
        val area = arguments?.getString("area")
        val location = arguments?.getString("location")

        val cropImg: ImageView = view.findViewById(R.id.cropImg)
        val cropDes: TextView = view.findViewById(R.id.cropDes)

        if(cropName == "wheat"){
            cropImg.setImageResource(R.drawable.wheat_image)
            cropImg.tag = "wheatImage"

            cropDes.text = "1. Wheat (Triticum aestivum)\n" +
                    "Type:\n" +
                    "Wheat is a cereal grain and a staple crop primarily grown in temperate regions. It belongs to the grass family (Poaceae) and is widely cultivated for its high nutritional value, especially for carbohydrate and protein content.\n" +
                    "\n" +
                    "Planting Season:\n" +
                    "Sowing Time: October–December\n" +
                    "\n" +
                    "Harvesting Time: March–May\n" +
                    "\n" +
                    "Optimal Temperature: 10–25°C with cool, dry weather during ripening\n" +
                    "\n" +
                    "Soil Requirement: Well-drained loamy or clayey soil with good moisture retention\n" +
                    "\n" +
                    "Minimum Area Required:\n" +
                    "Small-scale farming: 1 acre\n" +
                    "\n" +
                    "Large-scale production: 10+ acres for commercial viability\n" +
                    "\n" +
                    "Pros & Cons:\n" +
                    "✅ Pros:\n" +
                    "\n" +
                    "High global demand and market stability\n" +
                    "\n" +
                    "Long shelf life compared to other crops\n" +
                    "\n" +
                    "Good source of carbohydrates and dietary fiber\n" +
                    "\n" +
                    "Mechanized farming available for large-scale production\n" +
                    "\n" +
                    "❌ Cons:\n" +
                    "\n" +
                    "High water requirement for irrigation\n" +
                    "\n" +
                    "Susceptibility to pests such as wheat rust and aphids\n" +
                    "\n" +
                    "Price fluctuations due to international market trends\n" +
                    "\n" +
                    "Common Pesticides Used:\n" +
                    "For Fungal Diseases: Propiconazole, Mancozeb\n" +
                    "\n" +
                    "For Insect Control: Imidacloprid, Chlorpyrifos\n" +
                    "\n" +
                    "For Weed Control: Glyphosate, Metribuzin\n" +
                    "\n" +
                    "Market Demand & Scope:\n" +
                    "Major markets: India, China, USA, Russia, European Union\n" +
                    "\n" +
                    "Used in flour production, bread, pasta, biscuits, and animal feed\n" +
                    "\n" +
                    "Wheat exports contribute significantly to India’s agricultural GDP\n" +
                    "\n" +
                    "Government Schemes (Yojanas):\n" +
                    "Pradhan Mantri Kisan Samman Nidhi (PM-KISAN): ₹6,000 per year for farmers\n" +
                    "\n" +
                    "Rashtriya Krishi Vikas Yojana (RKVY): Funding for farm development\n" +
                    "\n" +
                    "Minimum Support Price (MSP): Government ensures a fixed price for wheat"
        }
        else if(cropName == "pea"){
            cropImg.setImageResource(R.drawable.pea_image)
            cropImg.tag = "peaImage"

            cropDes.text = "Pea (Pisum sativum)\n" +
                    "Type:\n" +
                    "Pea is a cool-season legume crop grown for its edible seeds, used both fresh and dried. It belongs to the Fabaceae family and is rich in protein, vitamins, and fiber.\n" +
                    "\n" +
                    "Planting Season:\n" +
                    "Sowing Time: October–November\n" +
                    "\n" +
                    "Harvesting Time: February–March\n" +
                    "\n" +
                    "Optimal Temperature: 10–20°C\n" +
                    "\n" +
                    "Soil Requirement: Well-drained sandy loam soil with a pH of 6.0–7.5\n" +
                    "\n" +
                    "Minimum Area Required:\n" +
                    "Commercial farming: 1 acre minimum\n" +
                    "\n" +
                    "Home gardening: 200 sq. ft. for small-scale production\n" +
                    "\n" +
                    "Pros & Cons:\n" +
                    "✅ Pros:\n" +
                    "\n" +
                    "Enriches soil fertility due to nitrogen fixation\n" +
                    "\n" +
                    "Requires less irrigation compared to wheat and rice\n" +
                    "\n" +
                    "High market demand, especially for frozen and processed peas\n" +
                    "\n" +
                    "Low input cost and good yield in a short period\n" +
                    "\n" +
                    "❌ Cons:\n" +
                    "\n" +
                    "Sensitive to excess moisture leading to root rot\n" +
                    "\n" +
                    "Susceptible to pests like aphids and pea moths\n" +
                    "\n" +
                    "Labor-intensive during harvesting\n" +
                    "\n" +
                    "Common Pesticides Used:\n" +
                    "For Fungal Control: Carbendazim, Mancozeb\n" +
                    "\n" +
                    "For Insect Control: Lambda-Cyhalothrin, Neem-based biopesticides\n" +
                    "\n" +
                    "For Weed Control: Pendimethalin, Imazethapyr\n" +
                    "\n" +
                    "Market Demand & Scope:\n" +
                    "Used in canning, frozen food, protein isolates, soups, and animal feed\n" +
                    "\n" +
                    "Export potential to Europe and North America\n" +
                    "\n" +
                    "Growing demand due to plant-based protein diets\n" +
                    "\n" +
                    "Government Schemes (Yojanas):\n" +
                    "National Food Security Mission (NFSM) - Pulses: Support for pulse production\n" +
                    "\n" +
                    "Paramparagat Krishi Vikas Yojana (PKVY): Organic farming assistance\n" +
                    "\n" +
                    "MSP for Pulses: Ensures price protection for farmers"
        }
        else if(cropName == "onion"){
            cropImg.setImageResource(R.drawable.onion_image)
            cropImg.tag = "OnionImage"

            cropDes.text = "Onion (Allium cepa)\n" +
                    "Type:\n" +
                    "Onion is a bulb vegetable belonging to the Amaryllidaceae family, widely used in cooking, condiments, and medicinal applications.\n" +
                    "\n" +
                    "Planting Season:\n" +
                    "Rabi Crop (Winter Onion): Sown in October–December, harvested in March–May\n" +
                    "\n" +
                    "Kharif Crop (Summer Onion): Sown in June–July, harvested in October–November\n" +
                    "\n" +
                    "Optimal Temperature: 15–25°C\n" +
                    "\n" +
                    "Soil Requirement: Well-drained sandy loam with high organic matter\n" +
                    "\n" +
                    "Minimum Area Required:\n" +
                    "Small-scale farming: 0.5–1 acre\n" +
                    "\n" +
                    "Large-scale onion farming: 5+ acres for export and storage benefits\n" +
                    "\n" +
                    "Pros & Cons:\n" +
                    "✅ Pros:\n" +
                    "\n" +
                    "High market demand year-round\n" +
                    "\n" +
                    "Long storage life (up to 6 months under proper conditions)\n" +
                    "\n" +
                    "Good export potential, especially to Gulf countries\n" +
                    "\n" +
                    "❌ Cons:\n" +
                    "\n" +
                    "Price fluctuations based on seasonal supply\n" +
                    "\n" +
                    "High labor costs for sowing, harvesting, and peeling\n" +
                    "\n" +
                    "Susceptible to storage rot and fungal diseases\n" +
                    "\n" +
                    "Common Pesticides Used:\n" +
                    "For Fungal Diseases: Difenoconazole, Propiconazole\n" +
                    "\n" +
                    "For Insect Control: Malathion, Spinosad\n" +
                    "\n" +
                    "For Weed Control: Oxyfluorfen, Pendimethalin\n" +
                    "\n" +
                    "Market Demand & Scope:\n" +
                    "Used in culinary products, dehydrated onion powder, and medicinal formulations\n" +
                    "\n" +
                    "Export potential to Bangladesh, UAE, Malaysia, and Sri Lanka\n" +
                    "\n" +
                    "India is the 2nd largest onion producer globally\n" +
                    "\n" +
                    "Government Schemes (Yojanas):\n" +
                    "Operation Greens: ₹500 crore scheme to stabilize onion prices\n" +
                    "\n" +
                    "Rashtriya Krishi Vikas Yojana (RKVY): Support for better storage and marketing\n" +
                    "\n" +
                    "MSP for Onion Farmers: Ensures stable pricing and prevents losses"
        }
        else{
            Toast.makeText(requireContext(), "Buddy how you get there with name: $cropName, $area and $location", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}