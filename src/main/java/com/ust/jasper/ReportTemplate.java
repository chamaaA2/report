package com.ust.jasper;

import net.sf.dynamicreports.report.base.expression.AbstractValueFormatter;
import net.sf.dynamicreports.report.builder.MarginBuilder;
import net.sf.dynamicreports.report.builder.ReportTemplateBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.datatype.BigDecimalType;
import net.sf.dynamicreports.report.builder.style.SimpleStyleBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizerBuilder;
import net.sf.dynamicreports.report.constant.ComponentPositionType;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.LineStyle;
import net.sf.dynamicreports.report.constant.VerticalAlignment;
import net.sf.dynamicreports.report.definition.ReportParameters;

import javax.xml.transform.Templates;
import java.awt.*;
import java.util.Locale;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.margin;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.tableOfContentsCustomizer;
import static net.sf.dynamicreports.report.builder.DynamicReports.template;

/**
 * Created by Palinda on 5/13/2015.
 */
public class ReportTemplate {

    public static final StyleBuilder rootStyle;
    public static final StyleBuilder boldStyle;
    public static final StyleBuilder italicStyle;
    public static final StyleBuilder boldCenteredStyle;
    public static final StyleBuilder titleColor;
    public static final StyleBuilder errorColor;
    public static final StyleBuilder bold12CenteredStyle;
    public static final StyleBuilder bold18CenteredStyle;
    public static final StyleBuilder bold22CenteredStyle;
    public static final StyleBuilder columnStyle;
    public static final StyleBuilder columnTitleStyle;
    public static final StyleBuilder detailStyle;
    public static final StyleBuilder detailWithLeftLineStyle;
    public static final StyleBuilder detailWithoutBorderStyle;
    public static final StyleBuilder detailWithRightBorderStyle;
    public static final StyleBuilder detailWithRightBorderStyleWithPadding;
    public static final StyleBuilder detailStyleWithLeftBorder;
    public static final StyleBuilder groupStyle;
    public static final StyleBuilder rightAlignStyle;
    public static final StyleBuilder leftAlignStyle;
    public static final StyleBuilder leftAlign;
    public static final StyleBuilder leftAlignWithPadding;
    public static final StyleBuilder leftAlignStyleBold;
    public static final StyleBuilder rightAlignStyleBold;
    public static final StyleBuilder subtotalStyle;
    public static final StyleBuilder subtitleColor;
    public static final StyleBuilder noticeColor;
    public static final StyleBuilder subGroupColor;
    public static final StyleBuilder subGroupColorWithWhiteBottom;
    public static final StyleBuilder subGroupFooterColor;
    public static final StyleBuilder subGroupFooterColorWithPadding;

    public static final StyleBuilder summaryTitleStyle;
    public static final StyleBuilder summaryTextStyle;
    public static final StyleBuilder justifiedText;

    public static final StyleBuilder orangeBackText;
    public static final StyleBuilder orangeBackTextBold;
    public static final StyleBuilder blueBackText;
    public static final StyleBuilder blueBackTextNew;
    public static final StyleBuilder grayBackText;
    public static final StyleBuilder paddingBlack;
    public static final StyleBuilder paddingBlackWithPadding;
    public static final StyleBuilder paddingBlackLeft;
    public static final StyleBuilder paddingBlackBold;
    public static final StyleBuilder paddingBlackLeftBold;
    public static final StyleBuilder paddingSixBlackLeftBold;

    public static final ReportTemplateBuilder reportTemplate;
    public static final ReportTemplateBuilder reportTemplateEvenHighLight;
    public static final ReportTemplateBuilder customColumnReportTemplate;
    public static final ReportTemplateBuilder customColumnReportTemplateEvenRawHighlight;
    public static final CurrencyType currencyType;
    public static final ComponentBuilder shortGrayLine;
    public static final ComponentBuilder longGrayLine;
    public static final StyleBuilder noneStyle;

    static {
        rootStyle           = stl.style().setPadding(2).setFontName("arial");
        boldStyle           = stl.style(rootStyle).bold();
        noneStyle           = stl.style(rootStyle).setForegroundColor(new Color(111, 112, 114)).setFontSize(8);
        orangeBackText      = stl.style(rootStyle).setBackgroundColor(new Color(248, 153, 1)).setBorder(stl.penThin().setLineColor(Color.WHITE)).setLeftPadding(10).setRightPadding(10);
        grayBackText      = stl.style(rootStyle).setBorder(stl.penThin().setLineColor(Color.WHITE)).setBackgroundColor(new Color(240,240,240)).setForegroundColor(new Color(111, 112, 114)).setFontSize(9).setLeftPadding(10).setRightPadding(10).setBottomPadding(6).setTopPadding(5).setAlignment(HorizontalAlignment.RIGHT, VerticalAlignment.MIDDLE);
        blueBackText       = stl.style(rootStyle).setBackgroundColor(new Color(	0, 156, 222)).setForegroundColor(Color.WHITE).setBorder(stl.penThin().setLineColor(Color.WHITE)).setLeftPadding(10).setRightPadding(10);
        blueBackTextNew     = stl.style(rootStyle).setBackgroundColor(new Color(	0, 156, 222)).setForegroundColor(Color.WHITE).setBorder(stl.penThin().setLineColor(Color.WHITE)).setFontSize(9).setLeftPadding(10).setRightPadding(10).setBottomPadding(6).setTopPadding(5);
        paddingBlack = stl.style(rootStyle).setFontSize(8).setAlignment(HorizontalAlignment.RIGHT, VerticalAlignment.MIDDLE);
        paddingBlackWithPadding = stl.style(rootStyle).setFontSize(9).setForegroundColor(new Color(111, 112, 114)).setBottomPadding(6).setAlignment(HorizontalAlignment.RIGHT, VerticalAlignment.MIDDLE);
        paddingBlackLeft = stl.style(paddingBlack).setForegroundColor(Color.WHITE).setBackgroundColor(new Color(	0, 156, 222)).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE).setPadding(1).bold();
        paddingBlackBold = stl.style(paddingBlack).setForegroundColor(new Color(77, 77, 79)).setBackgroundColor(Color.WHITE).setAlignment(HorizontalAlignment.RIGHT, VerticalAlignment.MIDDLE).setBorder(stl.pen1Point().setLineColor(Color.WHITE))
            .setTopPadding(6)
            .setBottomPadding(4)
            .setRightPadding(4)
            .bold();
        paddingBlackLeftBold = stl.style(paddingBlack).setForegroundColor(new Color(77, 77, 79)).setBackgroundColor(Color.WHITE).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE)
            .setTopPadding(4)
            .setBottomPadding(4).setLeftPadding(2).bold();
        paddingSixBlackLeftBold = stl.style(paddingBlack).setForegroundColor(new Color(77, 77, 79)).setBackgroundColor(Color.WHITE).setAlignment(HorizontalAlignment.LEFT, VerticalAlignment.MIDDLE).setBorder(stl.pen1Point().setLineColor(Color.WHITE))
            .setTopPadding(6)
            .setBottomPadding(4).setLeftPadding(5).bold();
        orangeBackTextBold = stl.style(orangeBackText).bold();
        summaryTitleStyle   = stl.style(rootStyle).setFontSize(10).setForegroundColor(new Color(241, 87, 33)).setFontName("arial").bold();
        summaryTextStyle = stl.style(rootStyle).setFontSize(8).setForegroundColor(new Color(111, 112, 114)).setFontName("arial").setTopPadding(7).bold();
        justifiedText       = stl.style(rootStyle).setAlignment(HorizontalAlignment.JUSTIFIED, VerticalAlignment.MIDDLE).setForegroundColor(new Color(111, 112, 114)).setFontSize(9);

        italicStyle         = stl.style(rootStyle).italic();
        boldCenteredStyle   = stl.style(boldStyle)
                .setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
        bold12CenteredStyle = stl.style(boldCenteredStyle)
                .setFontSize(12);
        bold18CenteredStyle = stl.style(boldCenteredStyle)
                .setFontSize(15);
        bold22CenteredStyle = stl.style(boldCenteredStyle)
                .setFontSize(22);
        columnStyle         = stl.style(rootStyle).setVerticalAlignment(VerticalAlignment.MIDDLE);
        detailStyle         = stl.style().setPadding(4).setTopPadding(6).setBottomPadding(6).setFontName("arial")
                                .setRightBorder(stl.pen(Float.valueOf(0.5F), LineStyle.SOLID).setLineColor(new Color(192, 190, 190))).setForegroundColor(new Color(111, 112, 114)).setFontSize(8);
        detailWithLeftLineStyle         = stl.style().setPadding(4).setTopPadding(6).setBottomPadding(6).setFontName("arial")
            .setLeftBorder(stl.pen(Float.valueOf(0.5F), LineStyle.SOLID).setLineColor(new Color(192, 190, 190))).setForegroundColor(new Color(111, 112, 114)).setFontSize(8);
        detailWithoutBorderStyle         = stl.style().setPadding(4).setTopPadding(6).setBottomPadding(6).setFontName("arial")
            .setForegroundColor(new Color(111, 112, 114)).setFontSize(8);
        detailWithRightBorderStyle         = stl.style().setPadding(4).setTopPadding(6).setBottomPadding(6).setFontName("arial")
            .setRightBorder(stl.pen(Float.valueOf(0.5F), LineStyle.SOLID).setLineColor(new Color(192, 190, 190))).setLeftBorder(stl.pen(Float.valueOf(0.5F), LineStyle.SOLID).setLineColor(new Color(192, 190, 190))).setForegroundColor(new Color(111, 112, 114)).setFontSize(8);
        detailWithRightBorderStyleWithPadding = stl.style().setPadding(4).setTopPadding(6).setBottomPadding(6).setRightPadding(8).setFontName("arial")
            .setRightBorder(stl.pen(Float.valueOf(0.5F), LineStyle.SOLID).setLineColor(new Color(192, 190, 190))).setLeftBorder(stl.pen(Float.valueOf(0.5F), LineStyle.SOLID).setLineColor(new Color(192, 190, 190))).setForegroundColor(new Color(111, 112, 114)).setFontSize(8);
        detailStyleWithLeftBorder         = stl.style().setLeftPadding(5).setTopPadding(6).setBottomPadding(6).setFontName("arial")
            .setLeftBorder(stl.pen(Float.valueOf(15), LineStyle.SOLID).setLineColor(Color.WHITE)).setRightBorder(stl.pen(Float.valueOf(0.5F), LineStyle.SOLID).setLineColor(new Color(192, 190, 190))).setForegroundColor(new Color(111, 112, 114)).setFontSize(8).setHorizontalAlignment(HorizontalAlignment.CENTER);
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
        titleColor          = stl.style(bold18CenteredStyle).setForegroundColor(new Color(0,156,222)).setFontName("arial").setBottomPadding(0).setBold(false);
        errorColor          = stl.style(rootStyle).setFontSize(11).setForegroundColor(new Color(255, 29, 29)).setFontName("arial");

        subtitleColor       = stl.style(rootStyle).setForegroundColor(new Color(77,77,79)).setFontName("arial").setFontSize(9).setBold(false);
        noticeColor      = stl.style(rootStyle).setForegroundColor(new Color(77,77,79)).setFontName("arial").setFontSize(7).setBold(false);
        subGroupColor       = stl.style(rootStyle).setForegroundColor(new Color(77,77,79)).setBackgroundColor(new Color(192, 190, 190)).setFontSize(8).setHorizontalAlignment(HorizontalAlignment.RIGHT).setFontName("arial").setBold(true);
        subGroupColorWithWhiteBottom   = stl.style(rootStyle).setForegroundColor(new Color(77,77,79)).setBackgroundColor(new Color(192, 190, 190)).setFontSize(8).setHorizontalAlignment(HorizontalAlignment.RIGHT).setFontName("arial")
            .setBottomBorder(stl.pen(Float.valueOf(10), LineStyle.SOLID).setLineColor(Color.WHITE)).setBottomPadding(7);
        subGroupFooterColor = stl.style(rootStyle).setForegroundColor(new Color(77,77,79)).setBackgroundColor(new Color(192, 190, 190)).setFontSize(8).setFontName("arial").setBold(true);
        subGroupFooterColorWithPadding = stl.style(rootStyle).setForegroundColor(new Color(77,77,79)).setBackgroundColor(new Color(192, 190, 190)).setFontSize(8).setRightPadding(3).setFontName("arial").setBold(true);
        rightAlignStyle     = stl.style().setHorizontalAlignment(HorizontalAlignment.RIGHT).setFontSize(8).setFontName("arial");
        leftAlignStyle      = stl.style(rootStyle).setForegroundColor(new Color(77,77,79)).setBackgroundColor(new Color(192,190,190)).setFontName("arial").setHorizontalAlignment(HorizontalAlignment.LEFT).setFontSize(8).setRightPadding(4).setBold(true);
        leftAlignStyleBold      = stl.style(rootStyle).setForegroundColor(new Color(77,77,79)).setBackgroundColor(new Color(192, 190, 190)).setFontName("arial").setHorizontalAlignment(HorizontalAlignment.LEFT).setFontSize(8).setRightPadding(4).setBold(true);
        rightAlignStyleBold     = stl.style(rootStyle).setForegroundColor(new Color(77,77,79)).setBackgroundColor(new Color(192,190,190)).setFontName("arial").setHorizontalAlignment(HorizontalAlignment.RIGHT).setLeftPadding(8).setFontSize(8).setRightPadding(4).setBold(true);
        leftAlign = stl.style(rootStyle).setForegroundColor(new Color(77,77,79)).setBackgroundColor(new Color(192,190,190)).setFontName("arial").setHorizontalAlignment(HorizontalAlignment.LEFT).setFontSize(8).setRightPadding(4).setBold(true);
        leftAlignWithPadding = stl.style(rootStyle).setForegroundColor(new Color(77,77,79)).setBackgroundColor(new Color(192,190,190)).setFontName("arial").setHorizontalAlignment(HorizontalAlignment.LEFT).setFontSize(8).setLeftPadding(5).setBold(true);
        shortGrayLine =         cmp.text("").setStyle(grayBackText).setFixedHeight(3).setFixedColumns(41);
        longGrayLine =          cmp.text("").setStyle(grayBackText).setFixedHeight(3);

        StyleBuilder crosstabGroupStyle      = stl.style(columnTitleStyle);
        StyleBuilder crosstabGroupTotalStyle = stl.style(columnTitleStyle)
                .setBackgroundColor(new Color(170, 170, 170));
        StyleBuilder crosstabGrandTotalStyle = stl.style(columnTitleStyle)
                .setBackgroundColor(new Color(140, 140, 140));
        StyleBuilder crosstabCellStyle       = stl.style(columnStyle)
                .setBorder(stl.pen1Point());

        TableOfContentsCustomizerBuilder tableOfContentsCustomizer = tableOfContentsCustomizer()
                .setHeadingStyle(0, stl.style(rootStyle).bold());
        SimpleStyleBuilder detailOddRowStyle = stl.simpleStyle().setBackgroundColor(new Color(240,240,240)).setTopPadding(5).setBottomPadding(5)
            .setRightBorder(stl.pen(Float.valueOf(0.5F), LineStyle.SOLID).setLineColor(new Color(192, 190, 190)));
        SimpleStyleBuilder detailOddRowWithOutBorderStyle = stl.simpleStyle().setBackgroundColor(new Color(240,240,240)).setTopPadding(5).setBottomPadding(5);


        reportTemplate = template()
                .setLocale(Locale.ENGLISH)
                .setColumnTitleStyle(columnTitleStyle)
                .setGroupStyle(groupStyle)
                .setColumnStyle(detailStyle)
                .setSubtotalStyle(subtotalStyle)
                .highlightDetailOddRows()
                .setDetailOddRowStyle(detailOddRowStyle)
                .crosstabHighlightEvenRows()
                .setCrosstabGroupStyle(crosstabGroupStyle)
                .setCrosstabGroupTotalStyle(crosstabGroupTotalStyle)
                .setCrosstabGrandTotalStyle(crosstabGrandTotalStyle)
                .setCrosstabCellStyle(crosstabCellStyle)
                .setTableOfContentsCustomizer(tableOfContentsCustomizer);

        reportTemplateEvenHighLight = template()
            .setLocale(Locale.ENGLISH)
            .setColumnTitleStyle(columnTitleStyle)
            .setGroupStyle(groupStyle)
            .setColumnStyle(detailStyle)
            .setSubtotalStyle(subtotalStyle)
            .highlightDetailEvenRows()
            .setDetailEvenRowStyle(detailOddRowStyle)
            .crosstabHighlightEvenRows()
            .setCrosstabGroupStyle(crosstabGroupStyle)
            .setCrosstabGroupTotalStyle(crosstabGroupTotalStyle)
            .setCrosstabGrandTotalStyle(crosstabGrandTotalStyle)
            .setCrosstabCellStyle(crosstabCellStyle)
            .setTableOfContentsCustomizer(tableOfContentsCustomizer);

        customColumnReportTemplate = template()
            .setLocale(Locale.ENGLISH)
            .setGroupStyle(groupStyle)
            .setColumnStyle(detailWithoutBorderStyle)
            .setSubtotalStyle(subtotalStyle)
            .highlightDetailEvenRows()
            .setDetailEvenRowStyle(detailOddRowWithOutBorderStyle)
            .crosstabHighlightEvenRows()
            .setCrosstabGroupStyle(crosstabGroupStyle)
            .setCrosstabGroupTotalStyle(crosstabGroupTotalStyle)
            .setCrosstabGrandTotalStyle(crosstabGrandTotalStyle)
            .setCrosstabCellStyle(crosstabCellStyle)
            .setTableOfContentsCustomizer(tableOfContentsCustomizer);

        customColumnReportTemplateEvenRawHighlight = template()
            .setLocale(Locale.ENGLISH)
            .setGroupStyle(groupStyle)
            .setColumnStyle(detailStyle)
            .setSubtotalStyle(subtotalStyle)
            .highlightDetailEvenRows()
            .setDetailEvenRowStyle(detailOddRowStyle)
            .crosstabHighlightEvenRows()
            .setCrosstabGroupStyle(crosstabGroupStyle)
            .setCrosstabGroupTotalStyle(crosstabGroupTotalStyle)
            .setCrosstabGrandTotalStyle(crosstabGrandTotalStyle)
            .setCrosstabCellStyle(crosstabCellStyle)
            .setTableOfContentsCustomizer(tableOfContentsCustomizer);

        currencyType = new CurrencyType();

    }

    /**
     * Creates custom component which is possible to add to any report band component
     */

    public static ComponentBuilder<?, ?> createTitleFooter(String date) {

        MarginBuilder mg = margin().setBottom(0);
        return cmp.horizontalList()
                .add(cmp.line().setStyle(stl.style().setTopPadding(12).setForegroundColor(Color.BLACK)))
                .newRow()
                .add(cmp.verticalGap(8))
                .add(
                        cmp.image(Templates.class.getResource("/META-INF/logo-small.png")).setFixedDimension(18, 21).setHorizontalAlignment(HorizontalAlignment.LEFT),
                        cmp.text(date).setStyle(subtitleColor).setStyle(rightAlignStyle.setBottomPadding(10).setBold(true)).setHorizontalAlignment(HorizontalAlignment.LEFT),
                        cmp.pageXofY()
                ).setPositionType(ComponentPositionType.FIX_RELATIVE_TO_BOTTOM);

    }

    public static CurrencyValueFormatter createCurrencyValueFormatter(String label) {
        return new CurrencyValueFormatter(label);
    }

    public static class CurrencyType extends BigDecimalType {
        private static final long serialVersionUID = 10L;

        @Override
        public String getPattern() {
            return "$ #,###.00";
        }
    }

    private static class CurrencyValueFormatter extends AbstractValueFormatter<String, Number> {
        private static final long serialVersionUID = 11L;

        private String label;

        public CurrencyValueFormatter(String label) {
            this.label = label;
        }

        @Override
        public String format(Number value, ReportParameters reportParameters) {
            return label + currencyType.valueToString(value, reportParameters.getLocale());
        }
    }

}
