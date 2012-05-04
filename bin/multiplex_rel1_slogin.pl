#!/usr/bin/perl
#
# Site specific customizations section
#
my $sg_server = "sg-hub.oceanobservatories.org";
#my $target_base = "http://67.58.40.163:3000/";
my $target_base = "http://ion-beta.oceanobservatories.org/";

my %browser;
   $browser{'Windows7'} 		= ['IE', 'Firefox'];
   $browser{'Windows XP'} 		= ['IE', 'Firefox'];
   $browser{'Windows Vista'} 	= ['IE', 'Firefox'];
   $browser{'Linux'} 			= ['Firefox'];
   $browser{'OS X'} 			= ['Safari', 'Firefox'];

my $generic_password = 'zootester63'; 
my %account;

   #$account{'administrator'}[0]{'name'} = 'testerfor.ooici@gmail.com';
   #$account{'administrator'}[0]{'password'} = $generic_password;
   #$account{'administrator'}[0]{'account_name'} = 'OOICI Testing Admin';

   $account{'new_user'}[0]{'name'} = 'ZooTester@gmail.com';
   $account{'new_user'}[0]{'password'} = $generic_password;
   $account{'new_user'}[0]{'account_name'} = 'Zoo Test1';

# Handle each file on the command line
foreach $fn (@ARGV) {
  my $script = "";
  my $try_count = 0;
  print STDERR "Processing  $fn \n";
  open(FILE, $fn) || die "cannot open file $fn\n";
  while (<FILE>) {
    s/^\s*package com.example.tests;$//;
    $script .= $_;
  }
  close(FILE);

  for $f (keys %browser ) { 
    for $i ( 0 .. $#{ $browser{$f} } ) 
      print STDERR "    Considering browser specific script for: $browser{$f}[$i] on $f    "; 
      $skip = 0;
      # Begin section for skipping consistently failed tests.
      #if (($fn =~ /Test_01/) && ( $f =~ /Windows7/) && ($browser{$f}[$i] =~ /Firefox/)) { $skip = 1;};
      #if (($fn =~ /Test_01/) && ( $f =~ /Windows Vista/) && ($browser{$f}[$i] =~ /Firefox/)) { $skip = 1;};

      
      #print STDERR "    OUTPUTTING browser specific script for: $browser{$f}[$i] on $f\n";

      # End section for skipping consistently failed tests.
      if ($skip == 1) {
        print STDERR "... SKIPPING!\n";
      } else {
        print STDERR "... GENERATING.\n";
      }
      if ($skip == 0) {

        $ofn = $fn;
        $ofn =~ s#^rel1_testcases.*/#generated_tests/#;
        #$ofn =~ s#^rel1_testcases/#generated_tests/#;
        $ofn =~ s#(\.java)#_$browser{$f}[$i] on $f$1#;
        $ofn =~ s/ /_/g;
        open(OUT, ">$ofn") || die "cannot open outfile $ofn\n";
        my $script_copy = $script;
  
        #
        # Modify the command to work without selenium grid setup
        #
        my $platform = "$browser{$f}[$i] on $f";
  #      my $sg_server = "sg-hub.oceanobservatories.org";
  #      my $target_base = "https://buildbot.oceanobservatories.org:8080/";
     
        $script_copy =~ s/selenium = new DefaultSelenium\("([^"]+)", 4444, "([^"]+)", "([^"]+)"\);/selenium = new DefaultSelenium("$sg_server", 4444, "$platform", "$target_base");/m;
  
        #
        # Now edit in the new username and password
        #  
        $script_copy =~ s/U_S_E_R-N_A_M_E_1/$account{'new_user'}[0]{'name'}/mg;
        $script_copy =~ s/P_A_S_S-W_O_R_D_1/$account{'new_user'}[0]{'password'}/mg;
        $script_copy =~ s/U_S_E_R-N_A_M_E/$account{'new_user'}[$try_count]{'name'}/mg;
        $script_copy =~ s/P_A_S_S-W_O_R_D/$account{'new_user'}[$try_count]{'password'}/mg;
        $script_copy =~ s/A_C_C_O_U_N_T-N_A_M_E/$account{'new_user'}[$try_count]{'account_name'}/mg;
         
        #
        # Rename the classes
        #
        my $ocn = $fn;
        $ocn =~ s#.*/##;
        $ocn =~ s/\.java//;
        my $cn = $ofn;
        $cn =~ s#.*/##;
        $cn =~ s/\.java//;
        $script_copy =~ s/$ocn/$cn/mg;
    
        print OUT $script_copy;
        close(OUT);
        # 0 is valid, so increment it after using it...
        $try_count++;
      } 
    } 
  }
}
