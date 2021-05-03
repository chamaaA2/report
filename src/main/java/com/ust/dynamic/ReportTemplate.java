package com.ust.dynamic;
import net.sf.dynamicreports.report.builder.ReportTemplateBuilder;
import net.sf.dynamicreports.report.builder.style.SimpleStyleBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizerBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.LineStyle;
import net.sf.dynamicreports.report.constant.VerticalAlignment;

import java.awt.*;
import java.util.Locale;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.tableOfContentsCustomizer;
import static net.sf.dynamicreports.report.builder.DynamicReports.template;

/**
 * Created by Palinda on 5/13/2015.
 */
public class ReportTemplate {

    public static final StyleBuilder rootStyle;
    public static final StyleBuilder columnStyle;
    public static final StyleBuilder columnTitleStyle;
    public static final StyleBuilder detailStyle;
    public static final StyleBuilder detailWithLeftLineStyle;
    public static final StyleBuilder detailWithRightBorderStyle;
    public static final StyleBuilder groupStyle;
    public static final StyleBuilder leftAlignStyleBold;
    public static final StyleBuilder rightAlignStyleBold;
    public static final StyleBuilder subtotalStyle;
    public static final ReportTemplateBuilder reportTemplate;
    public static final StyleBuilder noneStyle;

    public static final StyleBuilder subGroupFooterColor ;

    static {
        rootStyle           = stl.style().setPadding(2).setFontName("arial");
        noneStyle           = stl.style(rootStyle).setForegroundColor(new Color(111, 112, 114)).setFontSize(8);
        columnStyle         = stl.style(rootStyle).setVerticalAlignment(VerticalAlignment.MIDDLE);
        detailStyle         = stl.style().setPadding(4).setTopPadding(6).setBottomPadding(6).setFontName("arial")
                                .setRightBorder(stl.pen(Float.valueOf(0.5F), LineStyle.SOLID).setLineColor(new Color(192, 190, 190))).setForegroundColor(new Color(111, 112, 114)).setFontSize(8);
        detailWithLeftLineStyle         = stl.style().setPadding(4).setTopPadding(6).setBottomPadding(6).setFontName("arial")
            .setLeftBorder(stl.pen(Float.valueOf(0.5F), LineStyle.SOLID).setLineColor(new Color(192, 190, 190))).setForegroundColor(new Color(111, 112, 114)).setFontSize(8);
        detailWithRightBorderStyle         = stl.style().setPadding(4).setTopPadding(6).setBottomPadding(6).setFontName("arial")
            .setRightBorder(stl.pen(Float.valueOf(0.5F), LineStyle.SOLID).setLineColor(new Color(192, 190, 190))).setLeftBorder(stl.pen(Float.valueOf(0.5F), LineStyle.SOLID).setLineColor(new Color(192, 190, 190))).setForegroundColor(new Color(111, 112, 114)).setFontSize(8);
        columnTitleStyle    = stl.style(columnStyle)
//                .setRightBorder(stl.pen(Float.valueOf(2), LineStyle.SOLID).setLineColor(new Color(242,243,243)))
                .setTopPadding(4)
                .setBottomPadding(4)
                .setHorizontalAlignment(HorizontalAlignment.CENTER)
//                .setBackgroundColor(new Color(51,122,183))
                .setForegroundColor(new Color(77,77,79)).setFontSize(8)
                .setBackgroundColor(Color.WHITE)
                .bold()
                .setFontName("arial");
        groupStyle    = stl.style(columnStyle)
                .setBorder(stl.pen1Point().setLineColor(Color.WHITE))
                .setTopPadding(6)
                .setLeftPadding(10)
                .setBottomPadding(6)
                .setHorizontalAlignment(HorizontalAlignment.LEFT)
                .setBackgroundColor(new Color(0,156,222))
                .setForegroundColor(Color.WHITE).setFontSize(8)
                .setFontName("arial")
                .bold();
//        groupStyle          = stl.style(boldStyle)
//                .setHorizontalAlignment(HorizontalAlignment.LEFT);
        subtotalStyle       = stl.style(rootStyle).setFontName("arial");
        subGroupFooterColor = stl.style(rootStyle).setForegroundColor(new Color(77,77,79)).setBackgroundColor(new Color(192, 190, 190)).setFontSize(8).setFontName("arial").setBold(true);
        leftAlignStyleBold      = stl.style(rootStyle).setForegroundColor(new Color(77,77,79)).setBackgroundColor(new Color(192, 190, 190)).setFontName("arial").setHorizontalAlignment(HorizontalAlignment.LEFT).setFontSize(8).setRightPadding(4).setBold(true);
        rightAlignStyleBold     = stl.style(rootStyle).setForegroundColor(new Color(77,77,79)).setBackgroundColor(new Color(192,190,190)).setFontName("arial").setHorizontalAlignment(HorizontalAlignment.RIGHT).setLeftPadding(8).setFontSize(8).setRightPadding(4).setBold(true);
        TableOfContentsCustomizerBuilder tableOfContentsCustomizer = tableOfContentsCustomizer()
                .setHeadingStyle(0, stl.style(rootStyle).bold());
        SimpleStyleBuilder detailOddRowStyle = stl.simpleStyle().setBackgroundColor(new Color(240,240,240)).setTopPadding(5).setBottomPadding(5)
            .setRightBorder(stl.pen(Float.valueOf(0.5F), LineStyle.SOLID).setLineColor(new Color(192, 190, 190)));


        reportTemplate = template()
                .setLocale(Locale.ENGLISH)
                .setColumnTitleStyle(columnTitleStyle)
                .setGroupStyle(groupStyle)
                .setColumnStyle(detailStyle)
                .setSubtotalStyle(subtotalStyle)
                .highlightDetailOddRows()
                .setDetailOddRowStyle(detailOddRowStyle)
                .crosstabHighlightEvenRows()
                .setTableOfContentsCustomizer(tableOfContentsCustomizer);
    }

}
