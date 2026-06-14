package com.medufly.edu.seeder;

import com.medufly.edu.entity.*;
import com.medufly.edu.repository.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataSeeder implements ApplicationRunner {

    private final CountryRepository countryRepository;
    private final UniversityRepository universityRepository;
    private final BlogPostRepository blogPostRepository;
    private final EventRepository eventRepository;
    private final TestimonialRepository testimonialRepository;

    public DataSeeder(CountryRepository countryRepository,
                      UniversityRepository universityRepository,
                      BlogPostRepository blogPostRepository,
                      EventRepository eventRepository,
                      TestimonialRepository testimonialRepository) {
        this.countryRepository = countryRepository;
        this.universityRepository = universityRepository;
        this.blogPostRepository = blogPostRepository;
        this.eventRepository = eventRepository;
        this.testimonialRepository = testimonialRepository;
    }

    private Map<String, Object> m(Object... kv) {
        var map = new LinkedHashMap<String, Object>();
        for (int i = 0; i < kv.length; i += 2) map.put(kv[i].toString(), kv[i + 1]);
        return map;
    }

    private List<Object> l(Object... items) {
        return List.of(items);
    }

    @Override
    public void run(ApplicationArguments args) {
        seedCountries();
        seedUniversities();
        seedBlogPosts();
        seedEvents();
        seedTestimonials();
    }

    private void seedCountries() {
        if (countryRepository.count() > 0) return;

        countryRepository.saveAll(List.of(
            Country.builder()
                .slug("russia").name("Russia").flag("🇷🇺")
                .tagline("Top-Ranked Universities | Affordable Fees | NMC Approved")
                .overview("Russia has been a top destination for Indian medical students for over three decades. With more than 40 NMC-approved medical universities offering MBBS in English, Russia provides world-class education at a fraction of the cost of private Indian medical colleges. The degree is globally recognised and students are eligible to appear for FMGE/NExT after returning to India.")
                .totalFees("₹20–28 Lakhs").duration("6 Years").language("English")
                .nmcApproved(true).neetRequired(true).intake("September")
                .highlights(l(
                    m("label", "Total Fees", "value", "₹20–28 Lakhs"),
                    m("label", "Duration", "value", "6 Years"),
                    m("label", "Medium", "value", "English"),
                    m("label", "NMC Approved", "value", "✓ Yes"),
                    m("label", "NEET Required", "value", "✓ Yes"),
                    m("label", "Intake", "value", "September")
                ))
                .fees(l(
                    m("year", "1st Year", "tuition", "3,80,000", "hostel", "75,000", "total", "4,55,000"),
                    m("year", "2nd Year", "tuition", "3,50,000", "hostel", "75,000", "total", "4,25,000"),
                    m("year", "3rd Year", "tuition", "3,50,000", "hostel", "75,000", "total", "4,25,000"),
                    m("year", "4th Year", "tuition", "3,50,000", "hostel", "75,000", "total", "4,25,000"),
                    m("year", "5th Year", "tuition", "3,50,000", "hostel", "75,000", "total", "4,25,000"),
                    m("year", "6th Year", "tuition", "3,50,000", "hostel", "75,000", "total", "4,25,000")
                ))
                .eligibility(l(
                    "Minimum 50% in Physics, Chemistry & Biology (PCB) in Class 12",
                    "Valid NEET qualifying score",
                    "Age: 17 years or above as on December 31 of admission year",
                    "Valid Indian passport",
                    "No upper age limit"
                ))
                .whyStudy(l(
                    m("title", "NMC Approved Universities", "desc", "42+ universities recognised by the National Medical Commission of India."),
                    m("title", "Affordable Total Cost", "desc", "Complete MBBS in ₹20–28 Lakhs including tuition and hostel fees."),
                    m("title", "English Medium", "desc", "All courses taught in English. No need to learn Russian for academics."),
                    m("title", "No Donation / Capitation", "desc", "Merit-based admissions with zero hidden charges."),
                    m("title", "Global Recognition", "desc", "Degree recognised by WHO, UNESCO and medical councils worldwide."),
                    m("title", "Safe & Student-Friendly", "desc", "Large Indian student community with dedicated Indian hostels and food.")
                ))
                .faqs(l(
                    m("q", "Is MBBS from Russia valid in India?", "a", "Yes. MBBS from NMC-approved Russian universities is valid in India. After completing the degree, students must clear FMGE/NExT to practice in India."),
                    m("q", "What is the total cost of MBBS in Russia?", "a", "The total cost including tuition, hostel, and other expenses ranges from ₹20–28 Lakhs over 6 years depending on the university."),
                    m("q", "Is NEET mandatory for MBBS in Russia?", "a", "Yes. As per NMC guidelines, NEET qualification is mandatory for Indian students seeking MBBS admission abroad."),
                    m("q", "What is the medium of instruction?", "a", "All NMC-approved universities in Russia offer MBBS in English. Students interact with patients in Russian, but academic curriculum is in English."),
                    m("q", "Is the climate a concern for Indian students?", "a", "Russia has cold winters, but Indian students adapt quickly. Universities provide well-heated hostels and all necessary facilities."),
                    m("q", "How does Medufly help with Russia MBBS?", "a", "Medufly provides end-to-end support — university selection, documentation, visa processing, travel, airport pickup, and ongoing support throughout your studies.")
                ))
                .build(),

            Country.builder()
                .slug("georgia").name("Georgia").flag("🇬🇪")
                .tagline("European Education | Low Cost | Safe for Indian Students")
                .overview("Georgia has emerged as a popular MBBS destination for Indian students due to its European-standard education, affordable fees, and welcoming environment. Georgian medical universities offer WHO and NMC-recognised MBBS programs in English. The country's proximity to Europe and its modern infrastructure make it an attractive option.")
                .totalFees("₹25–35 Lakhs").duration("6 Years").language("English")
                .nmcApproved(true).neetRequired(true).intake("September")
                .highlights(l(
                    m("label", "Total Fees", "value", "₹25–35 Lakhs"),
                    m("label", "Duration", "value", "6 Years"),
                    m("label", "Medium", "value", "English"),
                    m("label", "NMC Approved", "value", "✓ Yes"),
                    m("label", "NEET Required", "value", "✓ Yes"),
                    m("label", "Intake", "value", "September")
                ))
                .fees(l(
                    m("year", "1st Year", "tuition", "4,50,000", "hostel", "80,000", "total", "5,30,000"),
                    m("year", "2nd Year", "tuition", "4,50,000", "hostel", "80,000", "total", "5,30,000"),
                    m("year", "3rd Year", "tuition", "4,50,000", "hostel", "80,000", "total", "5,30,000"),
                    m("year", "4th Year", "tuition", "4,50,000", "hostel", "80,000", "total", "5,30,000"),
                    m("year", "5th Year", "tuition", "4,50,000", "hostel", "80,000", "total", "5,30,000"),
                    m("year", "6th Year", "tuition", "4,50,000", "hostel", "80,000", "total", "5,30,000")
                ))
                .eligibility(l(
                    "Minimum 50% in Physics, Chemistry & Biology in Class 12",
                    "Valid NEET qualifying score",
                    "Age: 17 years or above",
                    "Valid Indian passport"
                ))
                .whyStudy(l(
                    m("title", "European Standard Education", "desc", "Georgian universities follow the European Bologna system of education."),
                    m("title", "Safe & Peaceful Country", "desc", "Georgia is known for its hospitality and safety for international students."),
                    m("title", "Affordable Living", "desc", "Low cost of living compared to Western Europe while maintaining European standards."),
                    m("title", "NMC & WHO Recognised", "desc", "All partner universities are recognised by NMC and WHO."),
                    m("title", "No Language Barrier", "desc", "Complete MBBS program offered in English medium."),
                    m("title", "Modern Infrastructure", "desc", "Well-equipped labs, hospitals and teaching facilities.")
                ))
                .faqs(l(
                    m("q", "Is MBBS from Georgia recognised in India?", "a", "Yes. MBBS from NMC-approved Georgian universities is recognised in India. Students must clear FMGE/NExT to practice."),
                    m("q", "What is the total cost of MBBS in Georgia?", "a", "The total cost ranges from ₹25–35 Lakhs over 6 years including tuition and accommodation."),
                    m("q", "Is Georgia safe for Indian students?", "a", "Yes, Georgia is considered one of the safest countries in Europe with a very low crime rate and a welcoming attitude towards international students."),
                    m("q", "What documents are required?", "a", "You need 10th and 12th marksheets, NEET scorecard, passport, passport-size photos, and a medical fitness certificate.")
                ))
                .build(),

            Country.builder()
                .slug("kazakhstan").name("Kazakhstan").flag("🇰🇿")
                .tagline("Modern Universities | Budget Friendly | NMC Recognised")
                .overview("Kazakhstan has become a sought-after destination for MBBS aspirants from India. The country offers high-quality medical education at very affordable fees. Kazakh medical universities are NMC-approved and WHO-recognised, making the degree valid for practice in India after clearing FMGE/NExT.")
                .totalFees("₹18–25 Lakhs").duration("5 Years").language("English")
                .nmcApproved(true).neetRequired(true).intake("September")
                .highlights(l(
                    m("label", "Total Fees", "value", "₹18–25 Lakhs"),
                    m("label", "Duration", "value", "5 Years"),
                    m("label", "Medium", "value", "English"),
                    m("label", "NMC Approved", "value", "✓ Yes"),
                    m("label", "NEET Required", "value", "✓ Yes"),
                    m("label", "Intake", "value", "September")
                ))
                .fees(l(
                    m("year", "1st Year", "tuition", "3,20,000", "hostel", "60,000", "total", "3,80,000"),
                    m("year", "2nd Year", "tuition", "3,20,000", "hostel", "60,000", "total", "3,80,000"),
                    m("year", "3rd Year", "tuition", "3,20,000", "hostel", "60,000", "total", "3,80,000"),
                    m("year", "4th Year", "tuition", "3,20,000", "hostel", "60,000", "total", "3,80,000"),
                    m("year", "5th Year", "tuition", "3,20,000", "hostel", "60,000", "total", "3,80,000")
                ))
                .eligibility(l(
                    "Minimum 50% in Physics, Chemistry & Biology in Class 12",
                    "Valid NEET qualifying score",
                    "Age: 17 years or above",
                    "Valid Indian passport"
                ))
                .whyStudy(l(
                    m("title", "Most Affordable", "desc", "One of the most budget-friendly MBBS destinations with complete cost under ₹25 Lakhs."),
                    m("title", "5-Year Program", "desc", "Kazakhstan offers a 5-year MBBS program — saving one year compared to most countries."),
                    m("title", "NMC Recognised", "desc", "All partner universities are NMC and WHO recognised."),
                    m("title", "Modern Campuses", "desc", "Modern university campuses with state-of-the-art medical facilities."),
                    m("title", "Indian Community", "desc", "Large and supportive Indian student community."),
                    m("title", "Stable Environment", "desc", "Kazakhstan is politically stable and safe for international students.")
                ))
                .faqs(l(
                    m("q", "Is MBBS from Kazakhstan valid in India?", "a", "Yes, from NMC-approved Kazakh universities after clearing FMGE/NExT."),
                    m("q", "Is MBBS in Kazakhstan 5 or 6 years?", "a", "Most universities in Kazakhstan offer a 5-year MBBS program."),
                    m("q", "What is the medium of instruction?", "a", "MBBS programs are offered in English at all NMC-approved universities.")
                ))
                .build(),

            Country.builder()
                .slug("kyrgyzstan").name("Kyrgyzstan").flag("🇰🇬")
                .tagline("Low Cost MBBS | NMC Approved | English Medium")
                .overview("Kyrgyzstan offers one of the most affordable MBBS programs in the world. The country has several NMC-approved universities that provide quality medical education in English. It's a popular choice among Indian students looking for budget-friendly medical education abroad.")
                .totalFees("₹15–22 Lakhs").duration("6 Years").language("English")
                .nmcApproved(true).neetRequired(true).intake("September")
                .highlights(l(
                    m("label", "Total Fees", "value", "₹15–22 Lakhs"),
                    m("label", "Duration", "value", "6 Years"),
                    m("label", "Medium", "value", "English"),
                    m("label", "NMC Approved", "value", "✓ Yes"),
                    m("label", "NEET Required", "value", "✓ Yes"),
                    m("label", "Intake", "value", "September")
                ))
                .fees(l(
                    m("year", "1st Year", "tuition", "2,50,000", "hostel", "55,000", "total", "3,05,000"),
                    m("year", "2nd Year", "tuition", "2,50,000", "hostel", "55,000", "total", "3,05,000"),
                    m("year", "3rd Year", "tuition", "2,50,000", "hostel", "55,000", "total", "3,05,000"),
                    m("year", "4th Year", "tuition", "2,50,000", "hostel", "55,000", "total", "3,05,000"),
                    m("year", "5th Year", "tuition", "2,50,000", "hostel", "55,000", "total", "3,05,000"),
                    m("year", "6th Year", "tuition", "2,50,000", "hostel", "55,000", "total", "3,05,000")
                ))
                .eligibility(l(
                    "Minimum 50% in PCB in Class 12",
                    "Valid NEET qualifying score",
                    "Age: 17 years or above",
                    "Valid Indian passport"
                ))
                .whyStudy(l(
                    m("title", "Lowest MBBS Fees", "desc", "Complete MBBS in under ₹22 Lakhs — one of the most affordable globally."),
                    m("title", "NMC Approved", "desc", "Partner universities are NMC and WHO recognised."),
                    m("title", "English Medium", "desc", "Full MBBS curriculum delivered in English."),
                    m("title", "No Separate Entrance", "desc", "Admission based on NEET score — no separate entrance test."),
                    m("title", "Indian Food Available", "desc", "Indian restaurants and hostels with Indian meals available."),
                    m("title", "Simple Process", "desc", "Straightforward documentation and visa process.")
                ))
                .faqs(l(
                    m("q", "Is MBBS from Kyrgyzstan valid in India?", "a", "Yes, from NMC-approved universities. Students must clear FMGE/NExT to practice in India."),
                    m("q", "What is the climate like?", "a", "Kyrgyzstan has a continental climate with cold winters and warm summers. Students adapt well with proper preparation.")
                ))
                .build(),

            Country.builder()
                .slug("uzbekistan").name("Uzbekistan").flag("🇺🇿")
                .tagline("Emerging Destination | Quality Education | Affordable")
                .overview("Uzbekistan is rapidly emerging as a popular MBBS destination for Indian students. With improving university infrastructure, English-medium programs, and affordable fees, Uzbekistan offers a great opportunity for students seeking quality medical education at low cost.")
                .totalFees("₹18–24 Lakhs").duration("6 Years").language("English")
                .nmcApproved(true).neetRequired(true).intake("September")
                .highlights(l(
                    m("label", "Total Fees", "value", "₹18–24 Lakhs"),
                    m("label", "Duration", "value", "6 Years"),
                    m("label", "Medium", "value", "English"),
                    m("label", "NMC Approved", "value", "✓ Yes"),
                    m("label", "NEET Required", "value", "✓ Yes"),
                    m("label", "Intake", "value", "September")
                ))
                .fees(l(
                    m("year", "1st Year", "tuition", "3,00,000", "hostel", "60,000", "total", "3,60,000"),
                    m("year", "2nd Year", "tuition", "3,00,000", "hostel", "60,000", "total", "3,60,000"),
                    m("year", "3rd Year", "tuition", "3,00,000", "hostel", "60,000", "total", "3,60,000"),
                    m("year", "4th Year", "tuition", "3,00,000", "hostel", "60,000", "total", "3,60,000"),
                    m("year", "5th Year", "tuition", "3,00,000", "hostel", "60,000", "total", "3,60,000"),
                    m("year", "6th Year", "tuition", "3,00,000", "hostel", "60,000", "total", "3,60,000")
                ))
                .eligibility(l(
                    "Minimum 50% in PCB in Class 12",
                    "Valid NEET qualifying score",
                    "Age: 17 years or above",
                    "Valid Indian passport"
                ))
                .whyStudy(l(
                    m("title", "Affordable Fees", "desc", "Complete MBBS under ₹24 Lakhs."),
                    m("title", "Cultural Similarity", "desc", "Uzbekistan's culture is close to India's — similar food, values, and hospitality."),
                    m("title", "NMC Recognised", "desc", "Partner universities are NMC and WHO approved."),
                    m("title", "Warm Climate", "desc", "Warm climate similar to North India — easy to adapt."),
                    m("title", "Growing Infrastructure", "desc", "Rapidly improving university and hospital infrastructure."),
                    m("title", "Indian Community", "desc", "Established Indian student community with support networks.")
                ))
                .faqs(l(
                    m("q", "Is Uzbekistan safe for Indian students?", "a", "Yes, Uzbekistan is known for its safety and hospitality towards international students."),
                    m("q", "Is MBBS from Uzbekistan recognised in India?", "a", "Yes, from NMC-approved universities, after clearing FMGE/NExT.")
                ))
                .build(),

            Country.builder()
                .slug("ukraine").name("Ukraine").flag("🇺🇦")
                .tagline("European Degree | Long History | English Medium")
                .overview("Ukraine was one of the most popular MBBS destinations for Indian students. Several Ukrainian universities are NMC-approved and WHO-recognised. Students who wish to study in Ukraine should consult with Medufly for the latest updates on admissions and safety.")
                .totalFees("₹22–30 Lakhs").duration("6 Years").language("English")
                .nmcApproved(true).neetRequired(true).intake("September")
                .highlights(l(
                    m("label", "Total Fees", "value", "₹22–30 Lakhs"),
                    m("label", "Duration", "value", "6 Years"),
                    m("label", "Medium", "value", "English"),
                    m("label", "NMC Approved", "value", "✓ Yes"),
                    m("label", "NEET Required", "value", "✓ Yes"),
                    m("label", "Intake", "value", "September")
                ))
                .fees(l(
                    m("year", "1st Year", "tuition", "3,80,000", "hostel", "70,000", "total", "4,50,000"),
                    m("year", "2nd Year", "tuition", "3,80,000", "hostel", "70,000", "total", "4,50,000"),
                    m("year", "3rd Year", "tuition", "3,80,000", "hostel", "70,000", "total", "4,50,000"),
                    m("year", "4th Year", "tuition", "3,80,000", "hostel", "70,000", "total", "4,50,000"),
                    m("year", "5th Year", "tuition", "3,80,000", "hostel", "70,000", "total", "4,50,000"),
                    m("year", "6th Year", "tuition", "3,80,000", "hostel", "70,000", "total", "4,50,000")
                ))
                .eligibility(l(
                    "Minimum 50% in PCB in Class 12",
                    "Valid NEET qualifying score",
                    "Age: 17 years or above",
                    "Valid Indian passport"
                ))
                .whyStudy(l(
                    m("title", "European Standard", "desc", "Ukrainian medical degrees follow European education standards."),
                    m("title", "Experienced Faculty", "desc", "Highly qualified professors with decades of teaching experience."),
                    m("title", "NMC Approved", "desc", "Universities recognised by NMC and WHO."),
                    m("title", "Affordable Fees", "desc", "Competitive fees compared to European countries."),
                    m("title", "English Medium", "desc", "All programs offered in English."),
                    m("title", "Strong Alumni Network", "desc", "Large network of Ukrainian MBBS graduates practicing in India.")
                ))
                .faqs(l(
                    m("q", "Is it safe to study MBBS in Ukraine?", "a", "Please contact Medufly for the latest updates on Ukraine admissions. Our counselors will provide current and accurate information."),
                    m("q", "Is MBBS from Ukraine valid in India?", "a", "Yes, from NMC-approved Ukrainian universities after clearing FMGE/NExT.")
                ))
                .build(),

            Country.builder()
                .slug("belarus").name("Belarus").flag("🇧🇾")
                .tagline("Eastern European Quality | NMC Approved | Affordable")
                .overview("Belarus offers quality MBBS education at affordable fees. Belarusian medical universities are known for their strong focus on practical training and research. The country provides a safe and conducive environment for international students.")
                .totalFees("₹20–28 Lakhs").duration("6 Years").language("English")
                .nmcApproved(true).neetRequired(true).intake("September")
                .highlights(l(
                    m("label", "Total Fees", "value", "₹20–28 Lakhs"),
                    m("label", "Duration", "value", "6 Years"),
                    m("label", "Medium", "value", "English"),
                    m("label", "NMC Approved", "value", "✓ Yes"),
                    m("label", "NEET Required", "value", "✓ Yes"),
                    m("label", "Intake", "value", "September")
                ))
                .fees(l(
                    m("year", "1st Year", "tuition", "3,50,000", "hostel", "65,000", "total", "4,15,000"),
                    m("year", "2nd Year", "tuition", "3,50,000", "hostel", "65,000", "total", "4,15,000"),
                    m("year", "3rd Year", "tuition", "3,50,000", "hostel", "65,000", "total", "4,15,000"),
                    m("year", "4th Year", "tuition", "3,50,000", "hostel", "65,000", "total", "4,15,000"),
                    m("year", "5th Year", "tuition", "3,50,000", "hostel", "65,000", "total", "4,15,000"),
                    m("year", "6th Year", "tuition", "3,50,000", "hostel", "65,000", "total", "4,15,000")
                ))
                .eligibility(l(
                    "Minimum 50% in PCB in Class 12",
                    "Valid NEET qualifying score",
                    "Age: 17 years or above",
                    "Valid Indian passport"
                ))
                .whyStudy(l(
                    m("title", "Strong Academic Program", "desc", "Belarus is known for rigorous and comprehensive medical training."),
                    m("title", "NMC Approved", "desc", "Universities are NMC and WHO recognised."),
                    m("title", "Affordable Fees", "desc", "Total cost under ₹28 Lakhs for 6 years."),
                    m("title", "Safe Country", "desc", "Belarus has low crime rates and is safe for international students."),
                    m("title", "English Medium", "desc", "MBBS programs available in English."),
                    m("title", "Practical Training", "desc", "Strong emphasis on clinical and practical training.")
                ))
                .faqs(l(
                    m("q", "Is MBBS from Belarus valid in India?", "a", "Yes, from NMC-approved Belarusian universities after clearing FMGE/NExT."),
                    m("q", "What is the climate in Belarus?", "a", "Belarus has a continental climate with cold winters. Indian students adapt with proper preparation.")
                ))
                .build(),

            Country.builder()
                .slug("china").name("China").flag("🇨🇳")
                .tagline("World-Class Universities | Recognised Globally | English Medium")
                .overview("China has been a major destination for Indian medical students, with many top universities offering MBBS in English. Post-COVID, new admissions for foreign students have had restrictions. Please contact Medufly for the latest updates on China MBBS admissions.")
                .totalFees("₹25–40 Lakhs").duration("6 Years").language("English")
                .nmcApproved(true).neetRequired(true).intake("September")
                .highlights(l(
                    m("label", "Total Fees", "value", "₹25–40 Lakhs"),
                    m("label", "Duration", "value", "6 Years"),
                    m("label", "Medium", "value", "English"),
                    m("label", "NMC Approved", "value", "✓ Yes"),
                    m("label", "NEET Required", "value", "✓ Yes"),
                    m("label", "Intake", "value", "September")
                ))
                .fees(l(
                    m("year", "1st Year", "tuition", "4,50,000", "hostel", "80,000", "total", "5,30,000"),
                    m("year", "2nd Year", "tuition", "4,50,000", "hostel", "80,000", "total", "5,30,000"),
                    m("year", "3rd Year", "tuition", "4,50,000", "hostel", "80,000", "total", "5,30,000"),
                    m("year", "4th Year", "tuition", "4,50,000", "hostel", "80,000", "total", "5,30,000"),
                    m("year", "5th Year", "tuition", "4,50,000", "hostel", "80,000", "total", "5,30,000"),
                    m("year", "6th Year", "tuition", "4,50,000", "hostel", "80,000", "total", "5,30,000")
                ))
                .eligibility(l(
                    "Minimum 50% in PCB in Class 12",
                    "Valid NEET qualifying score",
                    "Age: 17–25 years",
                    "Valid Indian passport",
                    "No criminal record"
                ))
                .whyStudy(l(
                    m("title", "World-Class Institutions", "desc", "Many Chinese medical universities are among the top in Asia."),
                    m("title", "Advanced Research", "desc", "Excellent research facilities and modern teaching hospitals."),
                    m("title", "NMC Approved", "desc", "Many universities recognised by NMC and WHO."),
                    m("title", "Multicultural", "desc", "Diverse international student community."),
                    m("title", "Modern Infrastructure", "desc", "State-of-the-art campuses and laboratories."),
                    m("title", "Global Recognition", "desc", "Degree recognised worldwide.")
                ))
                .faqs(l(
                    m("q", "Are new admissions open for China MBBS?", "a", "Post-COVID, China had restrictions on new foreign student admissions. Please contact Medufly for the latest updates."),
                    m("q", "Is MBBS from China valid in India?", "a", "Yes, from NMC-approved Chinese universities after clearing FMGE/NExT.")
                ))
                .build(),

            Country.builder()
                .slug("philippines").name("Philippines").flag("🇵🇭")
                .tagline("US-Pattern MBBS | English Speaking Country | Tropical Climate")
                .overview("The Philippines offers MBBS (MD) education following the US medical education pattern. As an English-speaking country with a strong healthcare system, the Philippines is an excellent destination for Indian students seeking globally recognised medical education with excellent clinical exposure.")
                .totalFees("₹22–32 Lakhs").duration("5.5 Years").language("English")
                .nmcApproved(true).neetRequired(true).intake("June / Nov")
                .highlights(l(
                    m("label", "Total Fees", "value", "₹22–32 Lakhs"),
                    m("label", "Duration", "value", "5.5 Years"),
                    m("label", "Medium", "value", "English"),
                    m("label", "NMC Approved", "value", "✓ Yes"),
                    m("label", "NEET Required", "value", "✓ Yes"),
                    m("label", "Intake", "value", "June / Nov")
                ))
                .fees(l(
                    m("year", "1st Year (BS)", "tuition", "2,80,000", "hostel", "70,000", "total", "3,50,000"),
                    m("year", "2nd Year (BS)", "tuition", "2,80,000", "hostel", "70,000", "total", "3,50,000"),
                    m("year", "MD — Year 1", "tuition", "3,50,000", "hostel", "70,000", "total", "4,20,000"),
                    m("year", "MD — Year 2", "tuition", "3,50,000", "hostel", "70,000", "total", "4,20,000"),
                    m("year", "MD — Year 3", "tuition", "3,50,000", "hostel", "70,000", "total", "4,20,000"),
                    m("year", "MD — Year 4", "tuition", "3,50,000", "hostel", "70,000", "total", "4,20,000")
                ))
                .eligibility(l(
                    "Minimum 50% in PCB in Class 12",
                    "Valid NEET qualifying score",
                    "Age: 17 years or above",
                    "Valid Indian passport",
                    "2-year BS Biology/Pre-med before MD program"
                ))
                .whyStudy(l(
                    m("title", "English-Speaking Nation", "desc", "No language barrier — Philippines is an official English-speaking country."),
                    m("title", "US-Pattern Education", "desc", "Follows US medical education pattern with 4-year MD after 2-year BS."),
                    m("title", "Clinical Exposure", "desc", "Large hospitals with diverse patient populations for clinical training."),
                    m("title", "Affordable Living", "desc", "Low cost of living in a tropical, student-friendly environment."),
                    m("title", "WHO Recognised", "desc", "All partner universities are WHO recognised."),
                    m("title", "Welcoming Culture", "desc", "Filipino culture is warm, inclusive and safe for Indian students.")
                ))
                .faqs(l(
                    m("q", "How many years is MBBS in Philippines?", "a", "Total duration is 5.5 years — 2 years BS Biology/Pre-med followed by 4 years MD program."),
                    m("q", "Is MBBS from Philippines valid in India?", "a", "Yes, from NMC-approved universities after clearing FMGE/NExT."),
                    m("q", "Is English used in daily life?", "a", "Yes, English is an official language of the Philippines — a major advantage for Indian students.")
                ))
                .build(),

            Country.builder()
                .slug("nepal").name("Nepal").flag("🇳🇵")
                .tagline("Nearest Destination | Similar Culture | No Visa Required")
                .overview("Nepal is the closest international MBBS destination for Indian students. As a neighbouring country with cultural similarities, no visa requirement for Indians, and NMC-approved universities, Nepal offers a comfortable transition for students who want to study abroad without going too far from home.")
                .totalFees("₹45–65 Lakhs").duration("5.5 Years").language("English")
                .nmcApproved(true).neetRequired(true).intake("Aug / Jan")
                .highlights(l(
                    m("label", "Total Fees", "value", "₹45–65 Lakhs"),
                    m("label", "Duration", "value", "5.5 Years"),
                    m("label", "Medium", "value", "English"),
                    m("label", "NMC Approved", "value", "✓ Yes"),
                    m("label", "NEET Required", "value", "✓ Yes"),
                    m("label", "Intake", "value", "Aug / Jan")
                ))
                .fees(l(
                    m("year", "1st Year", "tuition", "8,00,000", "hostel", "80,000", "total", "8,80,000"),
                    m("year", "2nd Year", "tuition", "8,00,000", "hostel", "80,000", "total", "8,80,000"),
                    m("year", "3rd Year", "tuition", "8,00,000", "hostel", "80,000", "total", "8,80,000"),
                    m("year", "4th Year", "tuition", "8,00,000", "hostel", "80,000", "total", "8,80,000"),
                    m("year", "5th Year", "tuition", "8,00,000", "hostel", "80,000", "total", "8,80,000"),
                    m("year", "Internship", "tuition", "3,00,000", "hostel", "80,000", "total", "3,80,000")
                ))
                .eligibility(l(
                    "Minimum 50% in PCB in Class 12",
                    "Valid NEET qualifying score",
                    "Age: 17 years or above",
                    "Valid Indian identity proof (passport preferred)"
                ))
                .whyStudy(l(
                    m("title", "No Visa Required", "desc", "Indian students do not need a visa to study in Nepal."),
                    m("title", "Cultural Similarity", "desc", "Similar culture, food, festivals and lifestyle to India."),
                    m("title", "Close to Home", "desc", "Easy to visit home during holidays and semester breaks."),
                    m("title", "NMC Approved", "desc", "Universities are NMC and WHO recognised."),
                    m("title", "English Medium", "desc", "Complete MBBS in English medium."),
                    m("title", "No Language Barrier", "desc", "Hindi and English are widely spoken and understood.")
                ))
                .faqs(l(
                    m("q", "Do Indian students need a visa for Nepal?", "a", "No. Indian citizens do not require a visa to travel to or study in Nepal."),
                    m("q", "Is MBBS from Nepal expensive?", "a", "Nepal is relatively more expensive than Russia or Kazakhstan but offers proximity and no visa requirement."),
                    m("q", "Is MBBS from Nepal valid in India?", "a", "Yes, from NMC-approved Nepalese universities after clearing FMGE/NExT.")
                ))
                .build()
        ));
    }

    private void seedUniversities() {
        if (universityRepository.count() > 0) return;

        universityRepository.saveAll(List.of(
            University.builder()
                .slug("sechenov-university").name("Sechenov University")
                .countrySlug("russia").countryName("Russia").flag("🇷🇺")
                .city("Moscow").founded(1758).nmc(true)
                .duration("6 Years").medium("English")
                .annualFee("₹3,80,000").hostelFee("₹75,000").totalFee("₹22–24 Lakhs")
                .intake("September").badge("Top Ranked")
                .overview("Sechenov University is the oldest and largest medical university in Russia and one of the top medical universities in the world. Founded in 1758, it has trained thousands of doctors from across the globe with world-class faculty and state-of-the-art hospitals.")
                .highlights(l("#1 in Russia", "Founded 1758", "NMC Approved", "20,000+ Students", "English Medium", "WHO Listed"))
                .courses(l("MBBS (6 Years)", "Dentistry", "Pharmacy", "Postgraduate Programs"))
                .facilities(l("Modern Teaching Hospitals", "Research Laboratories", "Student Hostels", "Sports Complex", "Central Library", "Indian Cafeteria"))
                .build(),

            University.builder()
                .slug("kazan-federal-university").name("Kazan Federal University")
                .countrySlug("russia").countryName("Russia").flag("🇷🇺")
                .city("Kazan").founded(1804).nmc(true)
                .duration("6 Years").medium("English")
                .annualFee("₹3,50,000").hostelFee("₹75,000").totalFee("₹20–22 Lakhs")
                .intake("September").badge("Popular")
                .overview("Kazan Federal University (KFU) is one of the oldest and most prestigious universities in Russia, established in 1804. The university is known for its strong medical faculty and has a large international student community including thousands of Indian students.")
                .highlights(l("Top 5 in Russia", "Founded 1804", "NMC Approved", "50,000+ Students", "English Medium", "WHO Listed"))
                .courses(l("MBBS (6 Years)", "Fundamental Medicine", "Dentistry", "Pharmacy"))
                .facilities(l("University Clinics", "Digital Library", "Modern Hostels", "Fitness Center", "Student Clubs", "Indian Food Available"))
                .build(),

            University.builder()
                .slug("bashkir-state-medical-university").name("Bashkir State Medical University")
                .countrySlug("russia").countryName("Russia").flag("🇷🇺")
                .city("Ufa").founded(1932).nmc(true)
                .duration("6 Years").medium("English")
                .annualFee("₹3,20,000").hostelFee("₹70,000").totalFee("₹18–20 Lakhs")
                .intake("September").badge("Affordable")
                .overview("Bashkir State Medical University (BSMU) is one of the most popular and affordable NMC-approved medical universities in Russia. Located in Ufa, the capital of Bashkortostan, BSMU is well known for its practical training approach and welcoming environment for Indian students.")
                .highlights(l("NMC Approved", "Founded 1932", "Affordable Fees", "Large Indian Community", "English Medium", "WHO Listed"))
                .courses(l("MBBS (6 Years)", "Pediatrics", "Dentistry", "Preventive Medicine"))
                .facilities(l("University Hospital", "Student Hostel", "Canteen", "Sports Hall", "Library", "Simulation Labs"))
                .build(),

            University.builder()
                .slug("kursk-state-medical-university").name("Kursk State Medical University")
                .countrySlug("russia").countryName("Russia").flag("🇷🇺")
                .city("Kursk").founded(1935).nmc(true)
                .duration("6 Years").medium("English")
                .annualFee("₹3,40,000").hostelFee("₹70,000").totalFee("₹19–22 Lakhs")
                .intake("September").badge("Popular")
                .overview("Kursk State Medical University is a highly reputed NMC-approved university established in 1935. It is particularly popular among Indian students for its English-medium program, experienced faculty, and affordable fee structure.")
                .highlights(l("NMC Approved", "Founded 1935", "English Medium", "4,000+ Foreign Students", "WHO Listed", "Affordable"))
                .courses(l("MBBS (6 Years)", "General Medicine", "Stomatology", "Pharmacy"))
                .facilities(l("Clinical Base Hospitals", "Hostel Facilities", "Library", "Sports Complex", "Student Canteen", "Indian Association"))
                .build(),

            University.builder()
                .slug("volgograd-state-medical-university").name("Volgograd State Medical University")
                .countrySlug("russia").countryName("Russia").flag("🇷🇺")
                .city("Volgograd").founded(1935).nmc(true)
                .duration("6 Years").medium("English")
                .annualFee("₹3,30,000").hostelFee("₹70,000").totalFee("₹18–21 Lakhs")
                .intake("September").badge("")
                .overview("Volgograd State Medical University is a respected federal institution established in 1935. The university is known for its strong clinical training programs and modern teaching methodology. It offers MBBS in English medium and is NMC approved.")
                .highlights(l("NMC Approved", "Founded 1935", "English Medium", "Federal University", "WHO Listed", "Modern Labs"))
                .courses(l("MBBS (6 Years)", "General Medicine", "Pediatrics", "Dentistry"))
                .facilities(l("Teaching Hospitals", "Anatomy Labs", "Hostel", "Library", "Canteen", "Sports Facilities"))
                .build(),

            University.builder()
                .slug("tbilisi-state-medical-university").name("Tbilisi State Medical University")
                .countrySlug("georgia").countryName("Georgia").flag("🇬🇪")
                .city("Tbilisi").founded(1918).nmc(true)
                .duration("6 Years").medium("English")
                .annualFee("₹4,50,000").hostelFee("₹80,000").totalFee("₹26–30 Lakhs")
                .intake("September").badge("Top Ranked")
                .overview("Tbilisi State Medical University (TSMU) is the leading medical university in Georgia, established in 1918. It follows European education standards and is NMC-recognized. TSMU is a preferred choice for Indian students seeking a European-style medical education.")
                .highlights(l("#1 in Georgia", "Founded 1918", "NMC Approved", "European Standards", "English Medium", "WHO Listed"))
                .courses(l("MBBS (6 Years)", "Dentistry", "Pharmacy", "Public Health"))
                .facilities(l("University Clinics", "Modern Labs", "Student Hostel", "Library", "Student Cafeteria", "Sports Complex"))
                .build(),

            University.builder()
                .slug("david-tvildiani-medical-university").name("David Tvildiani Medical University")
                .countrySlug("georgia").countryName("Georgia").flag("🇬🇪")
                .city("Tbilisi").founded(1990).nmc(true)
                .duration("6 Years").medium("English")
                .annualFee("₹4,20,000").hostelFee("₹80,000").totalFee("₹24–28 Lakhs")
                .intake("September").badge("Popular")
                .overview("David Tvildiani Medical University (DTMU) in Tbilisi is a prominent private medical university in Georgia known for its international faculty, modern facilities, and strong clinical training. It is NMC-approved and popular among Indian students.")
                .highlights(l("NMC Approved", "Founded 1990", "International Faculty", "English Medium", "WHO Listed", "Modern Campus"))
                .courses(l("MBBS (6 Years)", "General Medicine", "Dentistry"))
                .facilities(l("Teaching Hospital", "Simulation Center", "Hostels", "Library", "Cafeteria", "Student Clubs"))
                .build(),

            University.builder()
                .slug("kazakh-national-medical-university").name("Kazakh National Medical University")
                .countrySlug("kazakhstan").countryName("Kazakhstan").flag("🇰🇿")
                .city("Almaty").founded(1930).nmc(true)
                .duration("5 Years").medium("English")
                .annualFee("₹3,20,000").hostelFee("₹60,000").totalFee("₹16–18 Lakhs")
                .intake("September").badge("Top Ranked")
                .overview("Kazakh National Medical University (KazNMU) in Almaty is the oldest and most prestigious medical university in Kazakhstan, established in 1930. It is NMC-approved and offers a 5-year MBBS program in English medium at very affordable fees.")
                .highlights(l("#1 in Kazakhstan", "Founded 1930", "NMC Approved", "5-Year Program", "English Medium", "WHO Listed"))
                .courses(l("MBBS (5 Years)", "General Medicine", "Dentistry", "Pharmacy"))
                .facilities(l("University Hospital", "Modern Labs", "Hostel", "Library", "Sports Facilities", "Cafeteria"))
                .build(),

            University.builder()
                .slug("astana-medical-university").name("Astana Medical University")
                .countrySlug("kazakhstan").countryName("Kazakhstan").flag("🇰🇿")
                .city("Astana").founded(1964).nmc(true)
                .duration("5 Years").medium("English")
                .annualFee("₹3,00,000").hostelFee("₹60,000").totalFee("₹15–17 Lakhs")
                .intake("September").badge("Affordable")
                .overview("Astana Medical University is a government medical university located in Astana (Nur-Sultan), the capital of Kazakhstan. Established in 1964, it is NMC-approved and offers an affordable 5-year MBBS program in English medium.")
                .highlights(l("NMC Approved", "Founded 1964", "Capital City", "5-Year Program", "English Medium", "Affordable Fees"))
                .courses(l("MBBS (5 Years)", "General Medicine", "Pediatrics"))
                .facilities(l("Clinical Training Hospital", "Hostel", "Labs", "Library", "Canteen", "Sports Hall"))
                .build(),

            University.builder()
                .slug("international-school-of-medicine").name("International School of Medicine")
                .countrySlug("kyrgyzstan").countryName("Kyrgyzstan").flag("🇰🇬")
                .city("Bishkek").founded(2003).nmc(true)
                .duration("6 Years").medium("English")
                .annualFee("₹2,80,000").hostelFee("₹55,000").totalFee("₹15–18 Lakhs")
                .intake("September").badge("Top Ranked")
                .overview("International School of Medicine (ISM) in Bishkek is one of the most popular NMC-approved universities in Kyrgyzstan for Indian students. Known for its international faculty, English-medium program, and strong FMGE pass rates.")
                .highlights(l("NMC Approved", "Founded 2003", "International Faculty", "English Medium", "High FMGE Rate", "Affordable"))
                .courses(l("MBBS (6 Years)", "General Medicine"))
                .facilities(l("Teaching Hospital", "Simulation Labs", "Hostels", "Library", "Cafeteria", "Indian Association"))
                .build(),

            University.builder()
                .slug("osh-state-university").name("Osh State University")
                .countrySlug("kyrgyzstan").countryName("Kyrgyzstan").flag("🇰🇬")
                .city("Osh").founded(1951).nmc(true)
                .duration("6 Years").medium("English")
                .annualFee("₹2,50,000").hostelFee("₹55,000").totalFee("₹14–16 Lakhs")
                .intake("September").badge("Affordable")
                .overview("Osh State University is one of the oldest and most affordable NMC-approved medical universities in Kyrgyzstan. Located in Osh, the second-largest city of Kyrgyzstan, it offers MBBS in English medium at one of the lowest fee structures globally.")
                .highlights(l("NMC Approved", "Founded 1951", "Lowest Fees", "English Medium", "WHO Listed", "Large Indian Community"))
                .courses(l("MBBS (6 Years)", "General Medicine", "Dentistry"))
                .facilities(l("University Hospital", "Hostel", "Library", "Labs", "Canteen", "Sports Ground"))
                .build(),

            University.builder()
                .slug("university-of-santo-tomas").name("University of Santo Tomas")
                .countrySlug("philippines").countryName("Philippines").flag("🇵🇭")
                .city("Manila").founded(1611).nmc(true)
                .duration("5.5 Years").medium("English")
                .annualFee("₹3,50,000").hostelFee("₹70,000").totalFee("₹20–23 Lakhs")
                .intake("June / November").badge("Top Ranked")
                .overview("The University of Santo Tomas (UST) in Manila is the oldest university in Asia, founded in 1611. Its Faculty of Medicine and Surgery is one of the most prestigious medical schools in the Philippines, offering US-pattern MD program in English.")
                .highlights(l("Oldest in Asia", "Founded 1611", "NMC Approved", "US-Pattern MD", "English Medium", "WHO Listed"))
                .courses(l("BS Biology (2 Years)", "Doctor of Medicine (4 Years)", "Dentistry", "Pharmacy"))
                .facilities(l("Teaching Hospitals", "Simulation Center", "Libraries", "Student Hostels", "Sports Facilities", "Cafeteria"))
                .build(),

            University.builder()
                .slug("belarusian-state-medical-university").name("Belarusian State Medical University")
                .countrySlug("belarus").countryName("Belarus").flag("🇧🇾")
                .city("Minsk").founded(1921).nmc(true)
                .duration("6 Years").medium("English")
                .annualFee("₹3,50,000").hostelFee("₹70,000").totalFee("₹20–24 Lakhs")
                .intake("September").badge("Top Ranked")
                .overview("Belarusian State Medical University (BSMU) in Minsk is the leading medical university in Belarus, established in 1921. It is NMC-approved and known for its rigorous academic curriculum, strong clinical training, and welcoming environment for Indian students.")
                .highlights(l("#1 in Belarus", "Founded 1921", "NMC Approved", "English Medium", "WHO Listed", "Practical Training"))
                .courses(l("MBBS (6 Years)", "General Medicine", "Dentistry", "Pharmacy"))
                .facilities(l("University Hospitals", "Research Labs", "Hostels", "Sports Complex", "Library", "Indian Canteen"))
                .build(),

            University.builder()
                .slug("tashkent-medical-academy").name("Tashkent Medical Academy")
                .countrySlug("uzbekistan").countryName("Uzbekistan").flag("🇺🇿")
                .city("Tashkent").founded(1919).nmc(true)
                .duration("6 Years").medium("English")
                .annualFee("₹3,00,000").hostelFee("₹60,000").totalFee("₹18–21 Lakhs")
                .intake("September").badge("Top Ranked")
                .overview("Tashkent Medical Academy is the oldest and most prestigious medical university in Uzbekistan, established in 1919. It is NMC-approved, offers MBBS in English medium, and is increasingly popular among Indian students for its affordable fees and improving infrastructure.")
                .highlights(l("#1 in Uzbekistan", "Founded 1919", "NMC Approved", "English Medium", "WHO Listed", "Affordable"))
                .courses(l("MBBS (6 Years)", "General Medicine", "Pediatrics", "Dentistry"))
                .facilities(l("Clinical Hospitals", "Modern Labs", "Hostel", "Library", "Cafeteria", "Indian Community"))
                .build()
        ));
    }

    private void seedBlogPosts() {
        if (blogPostRepository.count() > 0) return;

        blogPostRepository.saveAll(List.of(
            BlogPost.builder()
                .slug("mbbs-abroad-vs-india-which-is-better")
                .title("MBBS Abroad vs India: Which is Better in 2026?")
                .category("Admission Tips").categoryColor("blue")
                .excerpt("Confused between studying MBBS in India vs abroad? We compare fees, duration, recognition, and career prospects to help you make the right decision.")
                .publishedAt(LocalDate.of(2026, 5, 15))
                .readTime("7 min read").author("Medufly Counselling Team")
                .content("""

## MBBS Abroad vs India: A Complete Comparison

Every year, over 1.5 lakh students appear for MBBS seats in India. With only around 1 lakh government seats available — and private college fees reaching ₹1 crore+ — studying MBBS abroad has become a highly practical choice.

### Fee Comparison

| Parameter | India (Private) | India (Government) | MBBS Abroad |
|-----------|----------------|-------------------|-------------|
| Total Fees | ₹80L – ₹1.2 Cr | ₹5–15 Lakhs | ₹15–40 Lakhs |
| Donation | ₹20–50 Lakhs | None | None |
| Duration | 5.5 Years | 5.5 Years | 5–6 Years |

### Key Advantages of MBBS Abroad

**1. No Capitation / Donation**
Indian private medical colleges often charge lakhs as capitation fees on top of regular tuition. Abroad, admission is purely merit-based through NEET.

**2. Globally Recognized Degree**
NMC-approved universities in Russia, Georgia, Kazakhstan and other countries offer degrees recognized by WHO and medical councils worldwide.

**3. English Medium Education**
Most popular MBBS abroad destinations (Russia, Georgia, Philippines, Kazakhstan) offer complete programs in English.

**4. Better Infrastructure**
Many foreign universities have modern hospital facilities and labs that provide excellent clinical exposure.

### What About FMGE / NExT?

Students who complete MBBS abroad must clear the **Foreign Medical Graduates Examination (FMGE)** — now being replaced by **NExT** — to practice in India. While this is an additional step, Medufly provides dedicated FMGE/NExT coaching guidance.

### Our Recommendation

If you couldn't secure a government MBBS seat in India, studying at an NMC-approved university abroad is an excellent alternative. Countries like Russia, Georgia, and Kazakhstan offer world-class education at 20–30% of the cost of private Indian colleges.

**Contact Medufly today for free personalized counselling.**
""")
                .build(),

            BlogPost.builder()
                .slug("neet-score-required-for-mbbs-abroad")
                .title("What NEET Score Do You Need for MBBS Abroad in 2026?")
                .category("NEET Abroad").categoryColor("orange")
                .excerpt("Wondering if your NEET score is enough for MBBS abroad? Read the complete guide on minimum qualifying scores, country-wise requirements, and tips to maximize your chances.")
                .publishedAt(LocalDate.of(2026, 5, 10))
                .readTime("5 min read").author("Medufly Counselling Team")
                .content("""

## NEET Score Requirements for MBBS Abroad (2026)

As per NMC (National Medical Commission) guidelines, **NEET qualification is mandatory** for all Indian students seeking MBBS admission in foreign medical universities.

### Minimum NEET Scores by Category

| Category | Minimum Percentile | Approx. Score |
|----------|-------------------|---------------|
| General | 50th Percentile | 137+ out of 720 |
| SC/ST/OBC | 40th Percentile | 107+ out of 720 |
| PwD | 45th Percentile | 122+ out of 720 |

> **Important:** While NMC sets the minimum qualifying marks, individual universities may have higher requirements. Medufly counselors help match your score to the right university.

### Country-Wise Competitive Scores

- **Russia**: 350–550+ (better universities require higher scores)
- **Georgia**: 300–450+
- **Kazakhstan**: 250–400+
- **Kyrgyzstan**: 150–350+
- **Philippines**: 300–500+

### Tips to Maximize Admission Chances

1. **Apply Early**: Top universities fill seats quickly. Apply as soon as NEET results are declared.
2. **Multiple Applications**: Apply to 2–3 universities simultaneously.
3. **Choose the Right Country**: Match your score and budget to the right destination.
4. **Use a Reliable Consultant**: Medufly has helped 5000+ students secure admission successfully.

### Need Help?

Call or WhatsApp Medufly at **8084842777** for free NEET score evaluation and university recommendation.
""")
                .build(),

            BlogPost.builder()
                .slug("student-visa-guide-mbbs-russia")
                .title("Complete Student Visa Guide for MBBS in Russia (2026)")
                .category("Visa Guide").categoryColor("green")
                .excerpt("Step-by-step guide to getting your Russian student visa. Documents required, timeline, common mistakes, and how Medufly helps you through the entire process.")
                .publishedAt(LocalDate.of(2026, 4, 28))
                .readTime("8 min read").author("Medufly Visa Team")
                .content("""

## Russian Student Visa Guide for MBBS (2026)

Getting a Russian student visa is a straightforward process if you have the right guidance. Medufly's visa team has processed hundreds of student visas and here's everything you need to know.

### Documents Required

**From the Student:**
- Valid Indian Passport (minimum 1.5 years validity)
- NEET Scorecard
- 10th & 12th Marksheets
- 4 Passport-Size Photos
- Medical Certificate (HIV/AIDS & Drug Free)
- Bank Statement (showing ₹2–3 Lakhs)

**From the University:**
- Invitation Letter (issued after admission confirmation)
- Admission Letter / Enrollment Certificate

### Step-by-Step Visa Process

**Step 1 — Get Admission Letter**
After paying the first year fees, the university issues an official admission letter.

**Step 2 — Apply for Visa Invitation**
The university applies to the Russian Ministry of Interior for a visa invitation on your behalf (takes 2–4 weeks).

**Step 3 — Submit Visa Application**
Visit the Russian Embassy/Consulate in your city with all required documents.

**Step 4 — Visa Stamping**
The student visa is typically issued within 5–10 working days.

**Step 5 — Travel**
Fly to Russia. Medufly arranges airport pickup and helps with arrival formalities.

### Timeline

| Stage | Approximate Time |
|-------|-----------------|
| Admission Confirmation | 1–2 weeks |
| Visa Invitation | 3–4 weeks |
| Visa Stamping | 5–10 working days |
| **Total** | **6–8 weeks** |

### How Medufly Helps

Medufly's dedicated visa team handles all paperwork, coordinates with the university, tracks your visa application, and ensures you are fully ready to travel on time.

**Call 8084842777 for visa assistance.**
""")
                .build(),

            BlogPost.builder()
                .slug("fmge-next-exam-complete-guide")
                .title("FMGE / NExT Exam: Complete Guide for MBBS Abroad Students")
                .category("FMGE / NExT").categoryColor("blue")
                .excerpt("Everything you need to know about FMGE and the upcoming NExT exam — eligibility, syllabus, pass rate, preparation tips, and how Medufly helps you crack it.")
                .publishedAt(LocalDate.of(2026, 4, 15))
                .readTime("9 min read").author("Medufly Counselling Team")
                .content("""

## FMGE / NExT: Complete Guide for Foreign Medical Graduates

If you're planning to study MBBS abroad and practice medicine in India, you must clear the **Foreign Medical Graduates Examination (FMGE)**, which is being replaced by **NExT (National Exit Test)**.

### What is FMGE?

FMGE is a screening test conducted by NBE (National Board of Examinations) for Indian citizens who have obtained their primary medical qualification from a foreign medical institution.

- **Frequency**: Twice a year (June & December)
- **Format**: 300 MCQs in 2 papers
- **Passing Marks**: 150/300 (50%)
- **Attempts**: Unlimited

### What is NExT?

NExT (National Exit Test) is the new unified licensing examination replacing FMGE and the final year MBBS exam in India. It will apply to both Indian and foreign medical graduates.

### Subjects Covered

Anatomy, Physiology, Biochemistry, Pathology, Pharmacology, Microbiology, Forensic Medicine, Surgery, Medicine, Obstetrics & Gynecology, Pediatrics, Orthopedics, Ophthalmology, ENT, Dermatology, Psychiatry, Community Medicine, Radiology

### Tips to Crack FMGE/NExT

1. **Start preparation from Year 3** of MBBS — don't wait until you return
2. **Focus on Indian clinical guidelines** — treatment protocols differ slightly
3. **Practice MCQs daily** — minimum 100 MCQs per day in final year
4. **Join a coaching program** — structured guidance makes a huge difference
5. **Medufly's FMGE/NExT Guidance** — we provide dedicated support and coaching referrals

### Pass Rate Statistics

The overall FMGE pass rate is approximately 15–25%, which is why early and structured preparation is crucial.

**Contact Medufly for FMGE coaching guidance and university recommendations with high pass rates.**
""")
                .build(),

            BlogPost.builder()
                .slug("top-10-nmc-approved-universities-russia")
                .title("Top 10 NMC Approved Universities in Russia for MBBS 2026")
                .category("Country Guide").categoryColor("orange")
                .excerpt("Detailed list of the top NMC-approved medical universities in Russia with fees, facilities, and Indian student reviews to help you choose the right one.")
                .publishedAt(LocalDate.of(2026, 4, 5))
                .readTime("10 min read").author("Medufly Research Team")
                .content("""

## Top 10 NMC Approved Universities in Russia for MBBS (2026)

Russia has over 40 NMC-approved medical universities. Here are the top 10 that Medufly recommends for Indian students based on academic quality, FMGE pass rates, fees, and student support.

### 1. Sechenov University, Moscow
- **Annual Fees**: ₹3,80,000 | **Total**: ₹22–24 Lakhs
- Russia's oldest and most prestigious medical university (1758)
- Best for students with NEET 500+

### 2. Kazan Federal University, Kazan
- **Annual Fees**: ₹3,50,000 | **Total**: ₹20–22 Lakhs
- One of Russia's top 5 universities, large Indian community

### 3. Kursk State Medical University, Kursk
- **Annual Fees**: ₹3,40,000 | **Total**: ₹19–22 Lakhs
- Very popular among Indian students, high FMGE rates

### 4. Bashkir State Medical University, Ufa
- **Annual Fees**: ₹3,20,000 | **Total**: ₹18–20 Lakhs
- Most affordable among top-tier universities

### 5. Volgograd State Medical University, Volgograd
- **Annual Fees**: ₹3,30,000 | **Total**: ₹18–21 Lakhs
- Strong practical training, modern infrastructure

### 6. Orenburg State Medical University, Orenburg
- **Annual Fees**: ₹3,00,000 | **Total**: ₹17–19 Lakhs
- Budget-friendly with good clinical exposure

### 7. Ryazan State Medical University, Ryazan
- **Annual Fees**: ₹3,10,000 | **Total**: ₹17–20 Lakhs
- Smaller city, peaceful environment, good faculty

### 8. Tver State Medical University, Tver
- **Annual Fees**: ₹2,90,000 | **Total**: ₹16–18 Lakhs
- Close to Moscow, excellent for travel

### 9. Smolensk State Medical University, Smolensk
- **Annual Fees**: ₹2,80,000 | **Total**: ₹15–17 Lakhs
- Among the most affordable NMC-approved options

### 10. Saratov State Medical University, Saratov
- **Annual Fees**: ₹3,00,000 | **Total**: ₹17–19 Lakhs
- Well-established, strong alumni network in India

### How to Choose the Right University?

Contact **Medufly at 8084842777** — our experts will match your NEET score, budget, and preferences to the ideal university from this list.
""")
                .build(),

            BlogPost.builder()
                .slug("life-as-indian-student-russia")
                .title("Life as an Indian Student in Russia: Everything You Need to Know")
                .category("Country Guide").categoryColor("orange")
                .excerpt("From Indian food to climate, hostel life to cultural experiences — a real guide to what daily life is like for Indian MBBS students in Russia.")
                .publishedAt(LocalDate.of(2026, 3, 22))
                .readTime("6 min read").author("Medufly Alumni Network")
                .content("""

## Life as an Indian Student in Russia

Thousands of Indian students study MBBS in Russia every year. Here's what daily life actually looks like — from the moment you land.

### Arrival & Initial Days

Most universities offer **airport pickup** (coordinated by Medufly). On arrival, you'll be taken to your hostel, helped with registration formalities, and introduced to other Indian students.

### Hostel Life

University hostels are safe, affordable, and well-maintained. Most students live in double or triple rooms. Rooms have heating (essential in Russian winters!), common kitchens, and Wi-Fi.

**Monthly hostel cost**: ₹4,000–8,000

### Food

This is one of the top concerns for Indian students — and rightly so. Here's the good news:

- Most university cities have **Indian grocery stores**
- Many hostels have **Indian students' cooking groups**
- Larger cities like Moscow, Kazan, Ufa have **Indian restaurants**
- **Maggi, dal, rice, masala** — all available in Russian supermarkets

### Climate

Russia has cold winters that go as low as -20°C in some cities. This is the biggest adjustment for Indian students.

**Tips:**
- Buy a good quality winter jacket before winter (October–November)
- Woolen thermals, gloves, and snow boots are must-haves
- The hostel and university buildings are always well-heated

### Cost of Living (Monthly)

| Expense | Amount |
|---------|--------|
| Hostel | ₹4,000–8,000 |
| Food | ₹5,000–8,000 |
| Transport | ₹1,000–2,000 |
| Miscellaneous | ₹2,000–3,000 |
| **Total** | **₹12,000–21,000** |

### Indian Community

Every university popular with Indian students has an **Indian Students Association**. These groups celebrate Diwali, Holi, and Independence Day, organize cricket matches, and help new students settle in.

### Homesickness

Most students fly home once a year during summer break (May–August). Video calls are easy and affordable with good internet connectivity.

**Medufly's team stays in touch with students throughout their course.** We're always a call away.
""")
                .build(),

            BlogPost.builder()
                .slug("mbbs-georgia-complete-guide-2026")
                .title("MBBS in Georgia 2026: Complete Guide for Indian Students")
                .category("Country Guide").categoryColor("orange")
                .excerpt("Everything about MBBS in Georgia — why it's gaining popularity, top universities, fees, visa process, and how Medufly helps you get admission.")
                .publishedAt(LocalDate.of(2026, 3, 10))
                .readTime("7 min read").author("Medufly Counselling Team")
                .content("""

## MBBS in Georgia 2026: Complete Guide

Georgia has emerged as one of the most popular MBBS destinations for Indian students in recent years. Here's a comprehensive guide to studying medicine in this beautiful European country.

### Why Georgia?

1. **European Standard Education** — Georgian universities follow the European Bologna system
2. **NMC Approved** — All our partner universities are NMC and WHO recognized
3. **Safe Country** — Very low crime rate, friendly locals
4. **English Medium** — No language barrier
5. **Affordable Fees** — ₹25–35 Lakhs total, much less than Indian private colleges

### Top Universities in Georgia

| University | City | Annual Fees | NMC |
|-----------|------|-------------|-----|
| Tbilisi State Medical University | Tbilisi | ₹4,50,000 | ✓ |
| David Tvildiani Medical University | Tbilisi | ₹4,20,000 | ✓ |
| Caucasus International University | Tbilisi | ₹3,80,000 | ✓ |
| Batumi Shota Rustaveli State University | Batumi | ₹3,50,000 | ✓ |

### Admission Process

1. Apply with NEET scorecard and academic documents
2. Receive admission letter from university
3. Pay first year fees
4. Apply for Georgian student visa
5. Travel to Georgia (Medufly arranges airport pickup)
6. Begin MBBS program

### Georgia vs Russia: Which is Better?

| Factor | Georgia | Russia |
|--------|---------|--------|
| Fees | ₹25–35 L | ₹18–28 L |
| Universities | 10 | 42+ |
| Climate | Mild | Very Cold |
| Education Style | European | Soviet-European |

**Both are excellent choices.** Our counselors help you decide based on your budget, NEET score, and preferences.

**Call Medufly at 8084842777 for free counselling.**
""")
                .build(),

            BlogPost.builder()
                .slug("documents-required-mbbs-abroad-india")
                .title("Documents Required for MBBS Abroad: Complete Checklist 2026")
                .category("Admission Tips").categoryColor("blue")
                .excerpt("Don't miss a single document. Here's the complete checklist of all documents required for MBBS abroad admission, visa, and travel — with tips to prepare them fast.")
                .publishedAt(LocalDate.of(2026, 2, 20))
                .readTime("5 min read").author("Medufly Documentation Team")
                .content("""

## Complete Document Checklist for MBBS Abroad (2026)

Missing even one document can delay your admission by months. Here's Medufly's complete checklist, verified across all popular MBBS destinations.

### Academic Documents

- [ ] Class 10 Marksheet & Certificate
- [ ] Class 12 Marksheet & Certificate
- [ ] NEET Scorecard (valid year)
- [ ] NEET Admit Card
- [ ] Transfer Certificate (if applicable)
- [ ] Migration Certificate (if applicable)

### Identity & Personal Documents

- [ ] Valid Passport (minimum 1.5 years validity from travel date)
- [ ] Aadhar Card (both sides)
- [ ] PAN Card
- [ ] 10–15 Passport-Size Photos (white/blue background)
- [ ] Birth Certificate

### Medical Documents

- [ ] Medical Fitness Certificate (from a registered doctor)
- [ ] HIV/AIDS Test Report (negative)
- [ ] Hepatitis B vaccination certificate (recommended)
- [ ] COVID vaccination certificate (some countries still require)

### Financial Documents

- [ ] Bank Statement (last 6 months)
- [ ] Income Proof of Parents (Form 16 / ITR)

### Post-Admission Documents (for Visa)

- [ ] Admission / Enrollment Letter from University
- [ ] Visa Invitation Letter (issued by university)
- [ ] Fee Payment Receipt

### Tips to Prepare Documents Fast

1. **Start collecting documents immediately after NEET results** — don't wait
2. **Get documents attested** by a notary/Gazetted officer where required
3. **Make multiple photocopies** of everything and scan them
4. **Store digitally** on Google Drive for quick sharing

### Medufly's Document Assistance

Our documentation team reviews your complete file, identifies gaps, and helps you prepare and submit everything correctly — minimizing any risk of rejection or delay.

**Call 8084842777 — free document review for every student.**
""")
                .build()
        ));
    }

    private void seedEvents() {
        if (eventRepository.count() > 0) return;

        eventRepository.saveAll(List.of(
            // Upcoming events
            Event.builder()
                .title("Free MBBS Abroad Seminar — Patna")
                .type("Seminar").typeColor("blue")
                .eventDate(LocalDate.of(2026, 7, 5))
                .eventTime("10:00 AM – 2:00 PM")
                .venue("Hotel Chanakya, Fraser Road, Patna")
                .seats(80).seatsLeft(23)
                .description("Join Medufly's flagship free seminar for MBBS 2026 aspirants. Meet university representatives from Russia, Georgia, and Kazakhstan. Get your questions answered by our expert counselors.")
                .highlights(l("University representatives present", "Free 1-on-1 counselling", "Document review on the spot", "Lucky draw for partial scholarship"))
                .isPast(false).active(true)
                .build(),

            Event.builder()
                .title("Online Webinar: NEET to MBBS Abroad — Step by Step")
                .type("Webinar").typeColor("orange")
                .eventDate(LocalDate.of(2026, 7, 12))
                .eventTime("6:00 PM – 8:00 PM")
                .venue("Online (Zoom)")
                .seats(500).seatsLeft(147)
                .description("Can't attend in person? Join our live online webinar where our experts walk you through the entire journey — from NEET scorecard to landing in your dream university abroad.")
                .highlights(l("Live Q&A session", "Country-wise fee breakdown", "Visa process explained", "Recording shared after event"))
                .isPast(false).active(true)
                .build(),

            Event.builder()
                .title("MBBS Abroad Education Fair — Ranchi")
                .type("Education Fair").typeColor("green")
                .eventDate(LocalDate.of(2026, 7, 20))
                .eventTime("11:00 AM – 5:00 PM")
                .venue("BNR Chanakya, Station Road, Ranchi")
                .seats(200).seatsLeft(68)
                .description("Meet 10+ NMC-approved universities under one roof. Compare fees, programs, and facilities. Spot admissions available for eligible students.")
                .highlights(l("10+ universities present", "Spot admission offers", "Free document check", "Parent-friendly sessions"))
                .isPast(false).active(true)
                .build(),

            Event.builder()
                .title("Free MBBS Counselling Camp — Muzaffarpur")
                .type("Counselling").typeColor("blue")
                .eventDate(LocalDate.of(2026, 8, 2))
                .eventTime("9:00 AM – 4:00 PM")
                .venue("Hotel Pavilion, Club Road, Muzaffarpur")
                .seats(60).seatsLeft(31)
                .description("Free one-on-one counselling sessions with Medufly's senior counselors. Bring your NEET scorecard and academic documents for on-the-spot university recommendations.")
                .highlights(l("1-on-1 counselling", "University shortlisting", "Visa guidance", "Parent Q&A session"))
                .isPast(false).active(true)
                .build(),

            // Past events
            Event.builder()
                .title("MBBS Abroad Seminar — Patna (Feb 2026)")
                .type("Seminar").typeColor("blue")
                .isPast(true).attendees(120).outcome("47 admissions confirmed")
                .active(true)
                .build(),

            Event.builder()
                .title("Online Webinar — January 2026")
                .type("Webinar").typeColor("orange")
                .isPast(true).attendees(380).outcome("89 applications received")
                .active(true)
                .build(),

            Event.builder()
                .title("Education Fair — Gaya (Nov 2025)")
                .type("Education Fair").typeColor("green")
                .isPast(true).attendees(195).outcome("62 students enrolled")
                .active(true)
                .build(),

            Event.builder()
                .title("Counselling Camp — Darbhanga (Oct 2025)")
                .type("Counselling").typeColor("blue")
                .isPast(true).attendees(74).outcome("28 admissions confirmed")
                .active(true)
                .build()
        ));
    }

    private void seedTestimonials() {
        if (testimonialRepository.count() > 0) return;

        testimonialRepository.saveAll(List.of(
            Testimonial.builder()
                .name("Priya Kumari").initials("PK").color("bg-brand-blue-700")
                .country("Russia").university("Kazan Federal University")
                .year("2023").rating(5)
                .quote("Medufly handled everything — from university selection to visa. I was scared about going abroad alone but they gave me confidence. Now I'm in my 3rd year and loving every bit of it.")
                .build(),

            Testimonial.builder()
                .name("Rohit Sharma").initials("RS").color("bg-brand-orange-500")
                .country("Georgia").university("Tbilisi State Medical University")
                .year("2022").rating(5)
                .quote("I tried getting into Indian colleges for 2 years. Medufly counselled me to Georgia and it was the best decision of my life. European education, English medium, and amazing infrastructure.")
                .build(),

            Testimonial.builder()
                .name("Anjali Singh").initials("AS").color("bg-green-600")
                .country("Kazakhstan").university("Astana Medical University")
                .year("2023").rating(5)
                .quote("The documentation process seemed overwhelming but Medufly's team was available 24/7. They even arranged airport pickup. Couldn't have asked for better support.")
                .build(),

            Testimonial.builder()
                .name("Vikash Tiwari").initials("VT").color("bg-purple-600")
                .country("Russia").university("Sechenov University")
                .year("2021").rating(5)
                .quote("I qualified FMGE on my first attempt after Medufly's coaching. Their mock tests are exactly like the real exam. 78% pass rate is real — I'm proof of it.")
                .build(),

            Testimonial.builder()
                .name("Neha Agarwal").initials("NA").color("bg-pink-600")
                .country("Philippines").university("University of Santo Tomas")
                .year("2022").rating(5)
                .quote("Philippines was not on my radar but Medufly explained the USMLE pathway, the English advantage, and the clinical exposure. Best counselling I ever got. Highly recommend.")
                .build(),

            Testimonial.builder()
                .name("Aditya Kumar").initials("AK").color("bg-teal-600")
                .country("Kyrgyzstan").university("Kyrgyz State Medical Academy")
                .year("2023").rating(4)
                .quote("Budget was my constraint. Medufly found me a quality NMC-approved university at under ₹20 lakhs total. I saved over ₹30 lakhs compared to private colleges in India.")
                .build(),

            Testimonial.builder()
                .name("Sonal Pandey").initials("SP").color("bg-yellow-600")
                .country("Nepal").university("Kathmandu University")
                .year("2022").rating(5)
                .quote("Nepal was a great choice — close to home, familiar culture, good food. Medufly made the transition seamless. They still check in on me every semester.")
                .build(),

            Testimonial.builder()
                .name("Rajan Mishra").initials("RM").color("bg-red-600")
                .country("Georgia").university("David Tvildiani Medical University")
                .year("2021").rating(5)
                .quote("I'm now a practicing doctor in Bihar. If not for Medufly, I would have given up my dream. 4 NEET attempts had broken my confidence but they believed in me.")
                .build(),

            Testimonial.builder()
                .name("Kavya Reddy").initials("KR").color("bg-indigo-600")
                .country("Russia").university("Kursk State Medical University")
                .year("2023").rating(5)
                .quote("Trustworthy, transparent, and genuinely helpful. No fake promises — they told me exactly what to expect. The hostel and food arrangements were exactly as described.")
                .build(),

            Testimonial.builder()
                .name("Sumit Jha").initials("SJ").color("bg-cyan-600")
                .country("Belarus").university("Grodno State Medical University")
                .year("2022").rating(4)
                .quote("Belarus was very affordable with excellent European clinical training. Medufly connected me with alumni before I made my decision — that transparency is rare.")
                .build(),

            Testimonial.builder()
                .name("Pooja Devi").initials("PD").color("bg-rose-600")
                .country("Uzbekistan").university("Tashkent Medical Academy")
                .year("2023").rating(5)
                .quote("My parents were skeptical about Uzbekistan but after Medufly arranged a call with a 5th-year student there, all doubts were cleared. Super supportive team.")
                .build(),

            Testimonial.builder()
                .name("Gaurav Singh").initials("GS").color("bg-emerald-600")
                .country("China").university("Jilin University")
                .year("2020").rating(5)
                .quote("I joined Medufly's FMGE coaching after returning from China. Qualified in the first attempt with 165/300. The mock tests gave me real exam confidence.")
                .build()
        ));
    }
}
