package com.medufly.edu;

import com.medufly.edu.dto.CountrySummary;
import com.medufly.edu.dto.HomeSummary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomePageIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void countriesSummary_returnsCounts() {
        String url = "http://localhost:" + port + "/api/home/countries-summary";
        HomeSummary summary = restTemplate.getForObject(url, HomeSummary.class);
        assertThat(summary).isNotNull();
        CountrySummary[] summaries = summary.getCountries().toArray(new CountrySummary[0]);
        assertThat(summaries.length).isEqualTo(2);

        boolean foundIndia = false;
        for (CountrySummary s : summaries) {
            if (s.getCountryId() == 1) {
                foundIndia = true;
                assertThat(s.getUniversityCount()).isEqualTo(3);
                assertThat(s.getCountryCode()).isEqualTo("IN");
                assertThat(s.getCountryName()).isEqualTo("India");
            }
            if (s.getCountryId() == 2) {
                assertThat(s.getUniversityCount()).isEqualTo(2);
                assertThat(s.getCountryCode()).isEqualTo("UK");
                assertThat(s.getCountryName()).isEqualTo("United Kingdom");
            }
        }
        assertThat(foundIndia).isTrue();

        // Verify services list is present (empty unless seeded)
        assertThat(summary.getServices()).isNotNull();
        // In our test seed we didn't add services, so list should be empty
        assertThat(summary.getServices().size()).isEqualTo(0);
    }
}


