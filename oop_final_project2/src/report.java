import  static java.lang.Math.*;
	import java.io.*;
	import java.time.LocalDate;
	import java.util.*;
	import java.util.concurrent.Executors;
	import java.util.concurrent.ThreadPoolExecutor;
	import java.io.FileWriter;
	import java.io.IOException;
	import org.apache.pdfbox.cos.COSDictionary;
	import org.apache.pdfbox.cos.COSName;
	import org.apache.pdfbox.pdmodel.PDDocument;
	import org.apache.pdfbox.pdmodel.PDPage;
	import org.apache.pdfbox.pdmodel.PDPageContentStream;
	import org.apache.pdfbox.pdmodel.font.PDFont;

	  
	import org.apache.pdfbox.pdmodel.font.PDType1Font;
	import org.apache.pdfbox.pdmodel.PDPage; 

	import java.io.File;  
	import org.apache.pdfbox.pdmodel.font.PDType0Font;




		public  class report  {
		    private String title;
		    private LocalDate startDate;
		    private LocalDate endDate;
		    private double totalEngagement;
		    private int totalPosts;

		    public report() {
		        this(" Default Report", LocalDate.now().minusMonths(1), LocalDate.now());
		        
		    }

		    public report(String title, LocalDate startDate, LocalDate endDate) {
		        this.title = title;
		        this.startDate = startDate;
		        this.endDate = endDate;
		    }

		    public String getTitle() {
		        return this.title;
		    }

		    public LocalDate getStartDate() {
		        return this.startDate;
		    }

		    public LocalDate getEndDate() {
		        return this.endDate;
		    }
		    

		    

		    

		    public  static void GeneratePdfData(String title, LocalDate startDate, LocalDate endDate, String... Datasets) {
		        System.out.println("Generating custom report: " + title);
		        System.out.println("Start Date: " + startDate);
		        System.out.println("End Date: " + endDate);
		        System.out.println("Datasetss:");
		        for (String Dataset : Datasets) {
		            System.out.println("- " + Dataset);
		        }
		    }

		    public void GeneratePdfData(String title, LocalDate startDate, LocalDate endDate, int... DatasetIds) {
		        System.out.println("Generating custom report: " + title);
		        System.out.println("Start Date: " + startDate);
		        System.out.println("End Date: " + endDate);
		        System.out.println("Datasetss Id:");
		        for (int DatasetId : DatasetIds) {
		            System.out.println("- " + DatasetId);
		        }
		    }

		    public void saveReportToFile(String filename, String format) {
		        try {
		            FileWriter writer = new FileWriter(filename);
		            writer.write("This is a sample report.");
		            writer.close();
		            System.out.println("Report saved to file: " + filename);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

		    
		    public void addEngagement(double engagement) {
		        this.totalEngagement += engagement;
		        this.totalPosts++;
		    }

		    public double getAverageEngagement() {
		        if (this.totalPosts == 0) {
		            return 0;
		        } else {
		            return this.totalEngagement / this.totalPosts;
		        }
		    }

		    public void printEngagementDetails() {
		        System.out.println("Total Engagement: " + this.totalEngagement);
		        System.out.println("Total Posts: " + this.totalPosts);
		        System.out.println("Average Engagement: " + getAverageEngagement());
		    }
		    public void calculateAverageEngagement() {
		        if (this.totalPosts == 0) {
		            System.out.println("No posts are there");
		        } else {
		            double averageEngagement = Math.round((this.totalEngagement / this.totalPosts) * 100.0) / 100.0;
		            System.out.println("Average Engagement: " + averageEngagement);
		        }
		    }
		    public static void GeneratePdf() {
		    //public static void main(String[] args) {
		    	try {
		            // Creating PDF mydoc object
		            PDDocument mydoc = new PDDocument();

		            // Generating custom report
		            String title = "Custom Report";//title of report
		            //starting date of gathering datasets
		            LocalDate startDate = LocalDate.now().minusMonths(1);
		            //ending date of gathering datasets
		            LocalDate endDate = LocalDate.now();
		            String[] Datasets = {"Data1:Facebookdata", "Data2:Instagramdata", "Data3:Youtubedata"};
		            GeneratePdfData(title, startDate, endDate, Datasets);

		            // Adding the custom report to the PDF mydoc
		            PDPage reportPage = new PDPage();
		            mydoc.addPage(reportPage);
		            PDPageContentStream contentStream = new PDPageContentStream(mydoc, reportPage);

		            // Set the font and add the report content to the PDF
		            contentStream.beginText();
		            File fontFile = new File("C:\\Users\\santu\\Downloads\\times-ro.ttf");
		            PDFont font = PDType0Font.load(mydoc, fontFile);
		            contentStream.setFont(font, 12);
		            contentStream.newLineAtOffset(25, 700);
		            contentStream.showText("Report Title: " + title);
		            contentStream.newLineAtOffset(0, -20);
		            contentStream.showText("Start Date: " + startDate);
		            contentStream.newLineAtOffset(0, -20);
		            contentStream.showText("End Date: " + endDate);
		            contentStream.newLineAtOffset(0, -20);
		            contentStream.showText("Datasets:");
		            int y = 640;
		            for (String Dataset : Datasets) {
		                contentStream.newLineAtOffset(0, -20);
		                contentStream.showText("- " + Dataset);
		                y -= 20;
		            }

		            // Add Facebookdata data to the PDF
		            Facebookdata Facebookdata = new Facebookdata();
		            contentStream.newLineAtOffset(0, -40);
		            contentStream.showText("Facebookdata Data:");
		            contentStream.newLineAtOffset(0, -20);
		            contentStream.showText("Number of Posts: " + Facebookdata.no_of_posts);
		            contentStream.newLineAtOffset(0, -20);
		            contentStream.showText("Number of Reactions: " + Facebookdata.no_of_reactions);
		            contentStream.newLineAtOffset(0, -20);
		            contentStream.showText("Number of Shares: " + Facebookdata.no_of_shares);
		            contentStream.newLineAtOffset(0, -20);
		            contentStream.showText("Number of Comments: " + Facebookdata.no_of_comments);
		         // Add Instagramdata data to the PDF
		            Instagramdata Instagramdata = new Instagramdata();
		            contentStream.newLineAtOffset(0, -40);
		            contentStream.showText("Instagramdata Data:");
		            contentStream.newLineAtOffset(0, -20);
		            contentStream.showText("Number of Shares: " + Instagramdata.no_of_shares);
		            contentStream.newLineAtOffset(0, -20);
		            contentStream.showText("Number of Likes: " + Instagramdata.no_of_likes);
		            contentStream.newLineAtOffset(0, -20);
		            contentStream.showText("Total Number of Followers: " + Instagramdata.total_no_of_followers);
		            contentStream.newLineAtOffset(0, -20);
		            contentStream.showText("Number of Comments: " + Instagramdata.no_of_comments);
		         // Add Youtubedata data to the PDF
		            Youtubedata Youtubedata = new Youtubedata();
		            contentStream.newLineAtOffset(0, -40);
		            contentStream.showText("Youtubedata Data:");
		            contentStream.newLineAtOffset(0, -20);
		            contentStream.showText("Number of Views: " + Youtubedata.no_of_views);
		            contentStream.newLineAtOffset(0, -20);
		            contentStream.showText("Number of Likes: " + Youtubedata.no_of_likes);
		            contentStream.newLineAtOffset(0, -20);
		            contentStream.showText("Number of Dislikes: " + Youtubedata.no_of_dislikes);
		            contentStream.newLineAtOffset(0, -20);
		            contentStream.showText("Number of Comments: " + Youtubedata.no_of_comments);
		            contentStream.endText();
		            contentStream.close();
		            

		            // Saving the mydoc
		            mydoc.save("E:/mypdf/my_doc.pdf");
		            System.out.println("PDF created");

		            // Closing the mydoc
		            mydoc.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

		  
		
}
