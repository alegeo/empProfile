<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="xml" />
<xsl:variable name="empRecord" select="document('empRecord.xml')/empRecord"/>
<xsl:variable name="companyInfo" select="document('companyInfo.xml')/companyInfo"/>
<xsl:variable name="transcript" select="document('transcript2.xml')/transcript"/> 
    <xsl:template match="/" > 
            <profile>
                <cv_info>
                <name><xsl:apply-templates select="cv/name" /> </name>
                <address><xsl:apply-templates select="cv/address" /> </address>
                <telephone><xsl:value-of select="cv/telephone" /> </telephone>
                <email><xsl:value-of select="cv/email" /></email>
                    <education>
                    <xsl:key name="kGrade" match="credits" use="../grade"/>
                    <univeirsity><xsl:value-of select="$transcript/univeirsity"/></univeirsity>
                    <program><xsl:value-of select="$transcript/program"/></program><GPA> 
                    <!-- <xsl:value-of select=" (4*(sum($transcript/courses/course[grade='A']/credits)) + 3*(sum($transcript/courses/course[grade='B']/credits)) + 2*(sum($transcript/courses/course[grade='C']/credits)) + 1*(sum($transcript/courses/course[grade='D']/credits))) div (sum($transcript/courses/course/credits))"/>  -->
                    <xsl:value-of select="format-number( (4*(sum($transcript/courses/course[grade='A']/credits)) + 3*(sum($transcript/courses/course[grade='B']/credits)) + 2*(sum($transcript/courses/course[grade='C']/credits)) + 1*(sum($transcript/courses/course[grade='D']/credits))) div (sum($transcript/courses/course/credits)), '#.000')"/>
                    </GPA> 
                    </education>
                <xsl:for-each select="cv/language"> 
                        <language> <xsl:value-of select="." /></language>
                </xsl:for-each>
                <qualifications><xsl:value-of select="cv/qualifications" /></qualifications>
                <jobType><xsl:value-of select="cv/jobType" /></jobType>
                <desiredPosition><xsl:value-of select="cv/desiredPosition" /></desiredPosition>
                <references><xsl:value-of select="cv/references" /> </references>
                <motivation><xsl:value-of select="cv/motivation" /> </motivation>
                </cv_info>
                
                <xsl:variable name="companyWorked" select="$empRecord/company"/>
                <xsl:for-each select="$empRecord">
                <empRecord>  
                    <company><xsl:value-of select="$empRecord/company"/></company>
                    <category/>
                    <contact><xsl:value-of select="$empRecord/contact"/></contact>
                    <year><xsl:value-of select="$empRecord/year"/></year>
                    <duration><xsl:value-of select="$empRecord/duration"/></duration>
                    <position><xsl:value-of select="$empRecord/position"/></position>
                </empRecord>
                </xsl:for-each>

                <xsl:value-of select="$companyWorked"></xsl:value-of>
                <xsl:value-of select="$companyInfo/name"></xsl:value-of>
                <xsl:choose>
                <xsl:when test="$companyInfo/company/name = $companyWorked">
                <companyInfo>    
                   <name><xsl:value-of select="$companyInfo/company/name"/></name>
                   <category><xsl:value-of select="$companyInfo/company/category"/></category>
                   <founders><xsl:value-of select="$companyInfo/company/founders"/></founders>
                   <ceo><xsl:value-of select="$companyInfo/company/ceo"/></ceo>
                   <location><xsl:value-of select="$companyInfo/company/location"/></location>
                   <contact><xsl:value-of select="$companyInfo/company/contact"/></contact>
                </companyInfo> 
                </xsl:when>
                <xsl:otherwise />
                </xsl:choose>    
                 
                 
        </profile>
    </xsl:template>
        	
</xsl:stylesheet>	