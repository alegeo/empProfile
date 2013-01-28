<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl='http://www.w3.org/1999/XSL/Transform' version="1.0"
                  xmlns:apcv='http://namespace.profile.com/ns/cv'
                  xmlns:com='http://namespace.profile.com/ns/com'
                  xmlns:t='http://namespace.profile.com/ns/transcript'
                  xmlns:e='http://namespace.profile.com/ns/empRecord'
                  xmlns:app='http://namespace.profile.com/ns/profile'
                  app:schemaLocation='http://namespace.profile.com/profile profile.xsd'>
<xsl:output method="xml" />
<xsl:variable name="empRecord" select="document('empRecord.xml')/e:empRecord"/>
<xsl:variable name="companyInfo" select="document('companyInfo.xml')/com:companyInfo/com:companies"/>
<xsl:variable name="transcript" select="document('transcript.xml')/t:transcript"/> 

    <xsl:template match="apcv:cv" > 
            <profile>
                <cv_info>
                <name><xsl:value-of select="apcv:name" /> </name>
                <address><xsl:value-of select="apcv:address" /> </address>
                <telephone><xsl:value-of select="apcv:telephone" /> </telephone>
                <email><xsl:value-of select="apcv:email" /></email>
                    <education>
                    <univeirsity><xsl:value-of select="$transcript/t:university"/></univeirsity>
                    <program><xsl:value-of select="$transcript/t:program"/></program><GPA> 
                    <!-- <xsl:value-of select=" (4*(sum($transcript/courses/course[grade='A']/credits)) + 3*(sum($transcript/courses/course[grade='B']/credits)) + 2*(sum($transcript/courses/course[grade='C']/credits)) + 1*(sum($transcript/courses/course[grade='D']/credits))) div (sum($transcript/courses/course/credits))"/>  -->
                    <xsl:value-of select="format-number( (4*(sum($transcript/t:courses/t:course[t:grade='A']/t:credits)) + 3*(sum($transcript/t:courses/t:course[t:grade='B']/t:credits)) + 2*(sum($transcript/t:courses/t:course[t:grade='C']/t:credits)) + 1*(sum($transcript/t:courses/t:course[t:grade='D']/t:credits))) div (sum($transcript/t:courses/t:course/t:credits)), '#.000')"/>
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
                
                <xsl:variable name="companyWorked" select="$empRecord/e:companyWorked/e:workedAtComId"/>
                <xsl:for-each select="$empRecord/e:companyWorked">
                <empRecord>  
                    <company><xsl:value-of select="$empRecord/e:companyWorked/e:workedAt"/></company>
                    <duration><xsl:value-of select="$empRecord/e:companyWorked/e:duration"/></duration>
                    <year><xsl:value-of select="$empRecord/e:companyWorked/e:year"/></year>
                    <position><xsl:value-of select="$empRecord/e:companyWorked/e:position"/></position>
                </empRecord>
                </xsl:for-each>
                    
                <xsl:for-each select="$companyInfo/*/com:companyId">
                <xsl:choose>
                <xsl:when test=". = $companyWorked">
                <companyInfo> 
                   <name><xsl:value-of select="../com:companyName"/></name>
                   <category><xsl:value-of select="../com:category"/></category>
                   <founders><xsl:value-of select="../com:founders"/></founders>
                   <ceo><xsl:value-of select="../com:ceo"/></ceo>
                   <location><xsl:value-of select="../com:location"/></location>
                   <contact><xsl:value-of select="../com:contact"/></contact>
                </companyInfo> 
                </xsl:when>
                <xsl:otherwise />
                </xsl:choose>    
                </xsl:for-each> 
        </profile>
    </xsl:template>
        	
</xsl:stylesheet>	