<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
                  xmlns:apcv='http://namespace.profile.com/ns/cv'
                  xmlns:e="http://namespace.profile.com/empRecord/e">
<xsl:output method="xml" />
<xsl:variable name="empRecord" select="document('empRecord.xml')"/>
<xsl:variable name="companyInfo" select="document('companyInfo.xml')/companyInfo"/>
<xsl:variable name="transcript" select="document('transcript.xml')/transcript"/> 
    <xsl:template match="apcv:cv" > 
            <profile>
                <cv_info>
                <name><xsl:value-of select="apcv:name" /> </name>
                <address><xsl:value-of select="apcv:address" /> </address>
                <telephone><xsl:value-of select="apcv:telephone" /> </telephone>
                <email><xsl:value-of select="apcv:email" /></email>
                    <education>
                    <univeirsity><xsl:value-of select="$transcript/univeirsity"/></univeirsity>
                    <program><xsl:value-of select="$transcript/program"/></program><GPA> 
                    <!-- <xsl:value-of select=" (4*(sum($transcript/courses/course[grade='A']/credits)) + 3*(sum($transcript/courses/course[grade='B']/credits)) + 2*(sum($transcript/courses/course[grade='C']/credits)) + 1*(sum($transcript/courses/course[grade='D']/credits))) div (sum($transcript/courses/course/credits))"/>  -->
                    <xsl:value-of select="format-number( (4*(sum($transcript/courses/course[grade='A']/credits)) + 3*(sum($transcript/courses/course[grade='B']/credits)) + 2*(sum($transcript/courses/course[grade='C']/credits)) + 1*(sum($transcript/courses/course[grade='D']/credits))) div (sum($transcript/courses/course/credits)), '#.000')"/>
                    </GPA> 
                    </education>
                <xsl:for-each select="apcv:language"> 
                        <language> <xsl:value-of select="." /></language>
                </xsl:for-each>
                <qualifications><xsl:value-of select="apcv:qualifications" /></qualifications>
                <jobType><xsl:value-of select="apcv:jobType" /></jobType>
                <desiredPosition><xsl:value-of select="apcv:desiredPosition" /></desiredPosition>
                <references><xsl:value-of select="apcv:references" /> </references>
                <motivation><xsl:value-of select="apcv:motivation" /> </motivation>
                </cv_info>
                
                <xsl:value-of select="$empRecord"/>
                <xsl:value-of select="$empRecord/workedAt"/>
                <xsl:value-of select="$empRecord/e:workedAt"/>
                
                <xsl:variable name="companyWorked" select="$empRecord/e:company"/>
                <xsl:for-each select="$empRecord">
                <empRecord>  
                    <company><xsl:value-of select="$empRecord/e:workedAt"/></company>
                    <duration><xsl:value-of select="$empRecord/e:druration"/></duration>
                    <year><xsl:value-of select="$empRecord/e:year"/></year>
                    <position><xsl:value-of select="$empRecord/e:position"/></position>
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