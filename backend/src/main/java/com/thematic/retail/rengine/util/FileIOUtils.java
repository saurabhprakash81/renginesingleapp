package com.thematic.retail.rengine.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.thematic.retail.rengine.model.ItemScore;

public class FileIOUtils {

	public static void writeCSVFile(List<ItemScore> itemScoreList) {
		ICsvBeanWriter beanWriter = null;
		CellProcessor[] processors = new CellProcessor[] { new ParseInt(), // Id
				new NotNull(), // Item Key
				new NotNull(), // title Name
				new NotNull(), // Department
				new NotNull(), // Category
				new NotNull(), // Sub Category
				new NotNull(), // Item Class
				new ParseInt(), // Cost
				new ParseInt(), // Abandonment Rate
				new ParseDouble(), // Score
				new ParseDouble(), // Adjusted Score
				new NotNull(), // Recommended
				new NotNull() // override
		};

		try {
			String FILE_NAME = "src/main/resources/output/itemScore" + getDateTime() + ".csv";
			File file = new File(FILE_NAME);
			beanWriter = new CsvBeanWriter(new FileWriter(file), CsvPreference.STANDARD_PREFERENCE);
			String[] header = { "id", "itemKey", "itemName", "department", "category", "subCategory", "itemClass",
					"cost", "abandonmentRate", "score", "adjustedScore", "recommended", "override" };
			beanWriter.writeHeader(header);

			for (ItemScore itemScore : itemScoreList) {
				beanWriter.write(itemScore, header, processors);
			}

		} catch (IOException ex) {
			System.err.println("Error writing the CSV file: " + ex);
		} finally {
			if (beanWriter != null) {
				try {
					beanWriter.close();
				} catch (IOException ex) {
					System.err.println("Error closing the writer: " + ex);
				}
			}
		}
	}

	private final static String getDateTime() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss");
		df.setTimeZone(TimeZone.getTimeZone("PST"));
		return df.format(new Date());
	}

}
