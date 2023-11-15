package interfaz_grafica;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

@SuppressWarnings("serial")
public class GraphDemo extends JPanel {
    private JFreeChart chart;

    public GraphDemo(List<Integer> availabilityDataList, int mes, String sede) {
        DefaultCategoryDataset dataset = createDataset(availabilityDataList);
        this.chart = createChart(dataset, mes, sede);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 400));
        this.add(chartPanel);
    }

    private DefaultCategoryDataset createDataset(List<Integer> availabilityDataList) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int day = 0; day < availabilityDataList.size(); day++) {
            int availability = availabilityDataList.get(day);
            dataset.addValue(availability, "Disponibilidad", "" + (day + 1));
        }
        return dataset;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataset, int mes, String sede) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM", Locale.getDefault());
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.MONTH, mes - 1); // Subtract 1 to convert from 1-based to 0-based index
        String monthName = dateFormat.format(calendar.getTime());

        JFreeChart chart = ChartFactory.createBarChart(
                "Disponibilidad de Automóviles en " + monthName + " - " + sede,
                monthName,
                "Cantidad de Automóviles",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.BLACK);
        CategoryAxis xAxis = (CategoryAxis) plot.getDomainAxis();
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);

        Font labelFont = xAxis.getLabelFont();
        Font smallerLabelFont = labelFont.deriveFont(10f);
        xAxis.setTickLabelFont(smallerLabelFont);

        BarRenderer renderer = new BarRenderer();
        plot.setRenderer(renderer);
        
        renderer.setSeriesPaint(0, Color.WHITE);
        

        return chart;
    }

    public JFreeChart getChart() {
        return chart;
    // Resto del código...
}
}
